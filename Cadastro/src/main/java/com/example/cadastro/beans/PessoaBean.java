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
import java.util.Map;
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
        carregarPessoaSeIdPresente();
    }

    /**
     * Se houver "id" como parâmetro na URL, carrega a pessoa para edição.
     */
    private void carregarPessoaSeIdPresente() {
        try {
            Map<String, String> params = FacesContext.getCurrentInstance()
                    .getExternalContext()
                    .getRequestParameterMap();

            String idParam = params.get("id");
            if (idParam != null && !idParam.isEmpty()) {
                Long id = Long.parseLong(idParam);
                pessoa = service.buscar(id);
                if (pessoa.getEnderecos() == null) {
                    pessoa.setEnderecos(new ArrayList<>());
                }
                for (Endereco e : pessoa.getEnderecos()) {
                    e.setPessoa(pessoa);
                }
            } else {
                pessoa = new Pessoa();
                pessoa.setEnderecos(new ArrayList<>());
            }
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Erro ao carregar pessoa por ID", e);
            addErrorMessage("Erro ao carregar dados da pessoa para edição.");
        }
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
                new Estado("AP", "Amapá"),
                new Estado("AM", "Amazonas"),
                new Estado("BA", "Bahia"),
                new Estado("CE", "Ceará"),
                new Estado("DF", "Distrito Federal"),
                new Estado("ES", "Espírito Santo"),
                new Estado("GO", "Goiás"),
                new Estado("MA", "Maranhão"),
                new Estado("MT", "Mato Grosso"),
                new Estado("MS", "Mato Grosso do Sul"),
                new Estado("MG", "Minas Gerais"),
                new Estado("PA", "Pará"),
                new Estado("PB", "Paraíba"),
                new Estado("PR", "Paraná"),
                new Estado("PE", "Pernambuco"),
                new Estado("PI", "Piauí"),
                new Estado("RJ", "Rio de Janeiro"),
                new Estado("RN", "Rio Grande do Norte"),
                new Estado("RS", "Rio Grande do Sul"),
                new Estado("RO", "Rondônia"),
                new Estado("RR", "Roraima"),
                new Estado("SC", "Santa Catarina"),
                new Estado("SP", "São Paulo"),
                new Estado("SE", "Sergipe"),
                new Estado("TO", "Tocantins")
        );
    }

    public String novaPessoa() {
        this.pessoa = new Pessoa();
        this.pessoa.setEnderecos(new ArrayList<>());
        return "form.xhtml?faces-redirect=true";
    }

    public String salvar() {
        try {
            if (pessoa.getEnderecos() != null) {
                for (Endereco e : pessoa.getEnderecos()) {
                    e.setPessoa(pessoa);
                }
            }
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
        Endereco novoEndereco = new Endereco();
        novoEndereco.setPessoa(pessoa);
        pessoa.getEnderecos().add(novoEndereco);
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

    public void setPessoas(List<Pessoa> pessoas) {
        this.pessoas = pessoas;
    }

    public List<Estado> getEstadosBrasil() {
        return estadosBrasil;
    }

    public void setEstadosBrasil(List<Estado> estadosBrasil) {
        this.estadosBrasil = estadosBrasil;
    }
}
