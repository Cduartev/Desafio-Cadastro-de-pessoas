# Cadastro de Pessoas  

![Java](https://img.shields.io/badge/Java-17-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)  
![JSF](https://img.shields.io/badge/JSF-2.2+-orange)  
![BootsFaces](https://img.shields.io/badge/BootsFaces-2.0.1+-blue)  
![PrimeFaces](https://img.shields.io/badge/PrimeFaces-14.0.4+-green)  
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-13+-blue?logo=postgresql)  
![Maven](https://img.shields.io/badge/Maven-3.6+-red?logo=apache-maven)  

Sistema de **cadastro e gerenciamento de pessoas** desenvolvido utilizando **Java EE**, **JSF**, **BootsFaces**, **PrimeFaces** e **JPA/Hibernate**, com integração ao **PostgreSQL**.  
O projeto foi estruturado para demonstrar boas práticas de desenvolvimento, arquitetura limpa e utilização de recursos modernos do ecossistema Java EE, combinando a simplicidade do BootsFaces com os componentes avançados do PrimeFaces.

---

## 📌 Funcionalidades

- **CRUD completo de pessoas**  
- **Gerenciamento de múltiplos endereços por pessoa**  
- **Validação de formulários no cliente e no servidor**  
- **Interface responsiva com BootsFaces (Bootstrap) e PrimeFaces**  
- **Integração total com PostgreSQL via JPA/Hibernate**  
- **Estrutura modular para fácil manutenção**  
- **Tabelas com filtragem e ordenação avançadas via PrimeFaces**  

---

## 🏗 Arquitetura e Tecnologias

**Frontend:** JSF + BootsFaces (Bootstrap integrado) + PrimeFaces  
**Backend:** Java 17, Java EE 11 (EJBs)  
**Persistência:** JPA + Hibernate  
**Banco de Dados:** PostgreSQL 13+  
**Build e Gestão de Dependências:** Maven 3.6+  
**Servidor de Aplicação:** WildFly (Java EE 11)  

---

## 💡 Por que escolhi cada tecnologia?

- **Java EE 11 + EJBs** → Fornece uma arquitetura robusta e padronizada para aplicações corporativas, com gerenciamento transacional e segurança embutidos.  
- **JSF (JavaServer Faces)** → Framework oficial da especificação Java EE para criação de interfaces web baseadas em componentes, facilitando a ligação entre backend e frontend.  
- **BootsFaces** → Integra **Bootstrap** diretamente ao JSF, garantindo **layout responsivo** e **componentes estilizados** com simplicidade e leveza.  
- **PrimeFaces** → Adicionado para fornecer componentes avançados, como tabelas com filtragem, ordenação e paginação, complementando o BootsFaces com funcionalidades mais ricas e interativas.  
- **JPA + Hibernate** → Abstrai o acesso ao banco de dados com mapeamento objeto-relacional (ORM), reduzindo código SQL e facilitando manutenção.  
- **PostgreSQL** → Banco de dados relacional poderoso, confiável, open-source e amplamente utilizado no mercado.  
- **Maven** → Gerenciador de dependências e build, garantindo reprodutibilidade do projeto e integração facilitada com servidores de aplicação.  
- **WildFly** → Servidor de aplicação Java EE moderno e de alta performance, com suporte nativo para EJBs, JPA e JSF.  

---

## 📊 BootsFaces x PrimeFaces — Integração no Projeto

| Critério                  | BootsFaces | PrimeFaces |
|---------------------------|------------|------------|
| **Integração com Bootstrap** | Nativa e pronta para uso | Necessita tema extra ou configuração |
| **Leveza**                | Mais leve, menos dependências JS | Mais pesado, mais scripts carregados |
| **Curva de aprendizado**  | Baixa, segue padrão Bootstrap | Média, precisa aprender componentes específicos |
| **Customização de CSS**   | Fácil (aproveita classes do Bootstrap) | Mais restrito, exige temas próprios |
| **Responsividade**        | Nativa via Bootstrap Grid | Depende do layout/tema |
| **Quantidade de componentes** | Menor, ideal para layouts simples | Muito maior, ideal para interatividade avançada |

> **Integração no Projeto:** O BootsFaces foi mantido para layouts responsivos e estilização leve baseada em Bootstrap, enquanto o PrimeFaces foi incorporado para componentes avançados, como tabelas com filtragem, ordenação e paginação. A combinação das duas bibliotecas permite um equilíbrio entre simplicidade, responsividade e funcionalidades interativas.

---

## ⚙️ Configuração do Ambiente

### **Pré-requisitos**
- **JDK 17+**
- **Maven 3.6+**
- **WildFly** (Java EE 11 compatível)
- **PostgreSQL 13+**

---

### **Instalação e Execução**

1. **Clonar o repositório**
   ```bash
   git clone https://github.com/Cduartev/Desafio-Cadastro-de-pessoas.git
   cd Desafio-Cadastro-de-pessoas
   ```

2. **Criar o banco de dados**
   ```sql
   CREATE DATABASE cadastro_pessoas;
   ```
   ![Diagrama UML](https://github.com/Cduartev/Desafio-Cadastro-de-pessoas/blob/master/Cadastro/relacionamento.png)

3. **Configurar credenciais no `persistence.xml`**  
   Ajuste usuário, senha e URL do banco conforme seu ambiente.

4. **Configurar tema do PrimeFaces (opcional)**  
   Adicione ao `web.xml` para definir um tema (exemplo: `saga-blue`):
   ```xml
   <context-param>
       <param-name>primefaces.THEME</param-name>
       <param-value>saga-blue</param-value>
   </context-param>
   ```

5. **Gerar e empacotar o projeto**
   ```bash
   mvn clean package
   ```

6. **Implantar no WildFly**  
   Copie o `.war` gerado para a pasta `standalone/deployments` do servidor.

7. **Acessar a aplicação**
   ```
   http://localhost:8080/Cadastro-1.0-SNAPSHOT/index.xhtml
   ```

---

## 📂 Estrutura do Projeto

```
Cadastro/
├─ .idea/                         # Configurações do IDE (IntelliJ IDEA)
├─ .mvn/                          # Arquivos do Maven (build e wrapper)
├─ src/
│  └─ main/
│     ├─ java/                     # Código-fonte Java (backend)
│     │  └─ com/example/cadastro/
│     │     ├─ beans/              # Managed Beans JSF
│     │     │  └─ PessoaBean.java  # Bean de controle de Pessoa
│     │     ├─ model/              # Modelos de dados
│     │     │  ├─ Endereco.java    # Classe Endereco
│     │     │  └─ Pessoa.java      # Classe Pessoa
│     │     └─ service/            # Lógica de negócio / serviços
│     │        ├─ PessoaService.java # Serviço de Pessoa (CRUD)
│     │        └─ HelloServlet.java  # Exemplo de Servlet
│     └─ resources/                # Recursos e configurações
│        └─ META-INF/
│           ├─ jboss-deployment-structure.xml # Configurações do WildFly
│           └─ persistence.xml    # Configuração do JPA/Hibernate
└─ webapp/                         # Frontend e páginas web
   └─ WEB-INF/
      ├─ web.xml                   # Configuração de servlets, filtros e JSF
      ├─ form.xhtml                # Página de formulário de cadastro
      ├─ index.jsp                 # Página inicial JSP (opcional)
      └─ index.xhtml               # Página inicial JSF
```

---

## 📜 Licença

Este projeto está licenciado sob a [MIT License](LICENSE).

---

## 📬 Contato

**Cayo Duarte Vidal**  
📧 Email: [cayoduartevidal@gmail.com](mailto:cayoduartevidal@gmail.com)  
🔗 GitHub: [Cduartev](https://github.com/Cduartev)  
