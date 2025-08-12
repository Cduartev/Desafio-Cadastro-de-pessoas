# Cadastro de Pessoas  

![Java](https://img.shields.io/badge/Java-17-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)  
![JSF](https://img.shields.io/badge/JSF-2.2+-orange)  
![PrimeFaces](https://img.shields.io/badge/PrimeFaces-10.0+-blue)  
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-13+-blue?logo=postgresql)  
![Maven](https://img.shields.io/badge/Maven-3.6+-red?logo=apache-maven)  

Sistema de **cadastro e gerenciamento de pessoas** desenvolvido utilizando **Java EE**, **JSF**, **PrimeFaces** e **JPA/Hibernate**, com integração ao **PostgreSQL**.  
O projeto foi estruturado para demonstrar boas práticas de desenvolvimento, arquitetura limpa e utilização de recursos avançados do ecossistema Java EE.  

---

## 📌 Funcionalidades

- **CRUD completo de pessoas**  
- **Gerenciamento de múltiplos endereços por pessoa**  
- **Validação de formulários no cliente e no servidor**  
- **Interface responsiva com PrimeFaces**  
- **Integração total com PostgreSQL via JPA/Hibernate**  
- **Estrutura modular para fácil manutenção**  

---

## 🏗 Arquitetura e Tecnologias

**Frontend:** JSF + PrimeFaces  
**Backend:** Java 17, Java EE 11 (EJBs)  
**Persistência:** JPA + Hibernate  
**Banco de Dados:** PostgreSQL 13+  
**Build e Gestão de Dependências:** Maven 3.6+  
**Servidor de Aplicação:** WildFly (Java EE 11)  

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

3. **Configurar credenciais no `persistence.xml`**  
   Ajuste usuário, senha e URL do banco conforme seu ambiente.

4. **Gerar e empacotar o projeto**
   ```bash
   mvn clean package
   ```

5. **Implantar no WildFly**  
   Copie o `.war` gerado para a pasta `standalone/deployments` do servidor.

6. **Acessar a aplicação**
   ```
   http://localhost:8080/cadastro-pessoas/
   ```

---

## 📂 Estrutura do Projeto

```
cadastro-pessoas/
 ├── src/main/java
 │    ├── br.com.cadastro.model     # Entidades JPA
 │    ├── br.com.cadastro.service   # EJBs e Regras de Negócio
 │    └── br.com.cadastro.controller# Managed Beans
 ├── src/main/resources
 │    └── META-INF/persistence.xml  # Configuração JPA
 ├── src/main/webapp
 │    |                   # Páginas JSF (xhtml)
 │    └── WEB-INF/web.xml           # Configuração web
 └── pom.xml                        # Dependências Maven
```

---

## 📜 Licença

Este projeto está licenciado sob a [MIT License](LICENSE).

---

## 📬 Contato

**Cayo Duarte Vidal**  
📧 Email: [cayoduartevidal@gmail.com](mailto:cayoduartevidal@gmail.com)  
🔗 GitHub: [Cduartev](https://github.com/Cduartev)  
