package com.example.cadastro.beans;

import com.example.cadastro.model.Endereco;
import com.example.cadastro.model.Pessoa;
import com.example.cadastro.service.PessoaService;
import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Named
@ViewScoped
public class PessoaBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private static final Logger logger = Logger.getLogger(PessoaBean.class.getName());

    @Inject
    private PessoaService service;

    private Pessoa pessoa = new Pessoa();
    private List<Pessoa> pessoas;
    private List<Estado> estadosBrasil;

    @PostConstruct
    public void init() {
        carregarPessoas();
        initEstadosBrasil();
    }

    private void carregarPessoas() {
        try {
            pessoas = service.listar();
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Erro ao carregar lista de pessoas", e);
            addErrorMessage("Erro ao carregar lista de pessoas. Por favor, tente novamente.");
        }
    }

    private void initEstadosBrasil() {
        estadosBrasil = Arrays.asList(
                new Estado("AC", "Acre"),
                new Estado("AL", "Alagoas"),
                // ... adicione os demais estados aqui ...
                new Estado("TO", "Tocantins")
        );
    }

    // Novo método para criar pessoa e ir para o formulário
    public String novaPessoa() {
        this.pessoa = new Pessoa();
        this.pessoa.setEnderecos(new ArrayList<>()); // Evita NullPointer ao adicionar endereço
        return "form.xhtml?faces-redirect=true";
    }

    public String salvar() {
        try {
            service.salvar(pessoa);
            carregarPessoas();
            pessoa = new Pessoa();
            addSuccessMessage("Pessoa salva com sucesso!");
            return "index.xhtml?faces-redirect=true";
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Erro ao salvar pessoa", e);
            addErrorMessage("Erro ao salvar pessoa. Por favor, tente novamente.");
            return null;
        }
    }

    public String editar(Long id) {
        try {
            pessoa = service.buscar(id);
            if (pessoa.getEnderecos() == null) {
                pessoa.setEnderecos(new ArrayList<>());
            }
            return "form.xhtml?faces-redirect=true";
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Erro ao buscar pessoa para edição", e);
            addErrorMessage("Erro ao carregar pessoa para edição.");
            return null;
        }
    }

    public void excluir(Long id) {
        try {
            service.excluir(id);
            carregarPessoas();
            addSuccessMessage("Pessoa excluída com sucesso!");
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Erro ao excluir pessoa", e);
            addErrorMessage("Erro ao excluir pessoa. Por favor, tente novamente.");
        }
    }

    public void adicionarEndereco() {
        if (pessoa.getEnderecos() == null) {
            pessoa.setEnderecos(new ArrayList<>());
        }
        pessoa.getEnderecos().add(new Endereco());
    }

    public void removerEndereco(Endereco endereco) {
        pessoa.getEnderecos().remove(endereco);
    }

    private void addSuccessMessage(String message) {
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", message));
    }

    private void addErrorMessage(String message) {
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", message));
    }

    // Classe interna para estados
    public static class Estado {
        private String sigla;
        private String nome;

        public Estado(String sigla, String nome) {
            this.sigla = sigla;
            this.nome = nome;
        }

        public String getSigla() {
            return sigla;
        }

        public String getNome() {
            return nome;
        }
    }

    // Getters e Setters
    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public List<Pessoa> getPessoas() {
        return pessoas;
    }

    public List<Estado> getEstadosBrasil() {
        return estadosBrasil;
    }
}
