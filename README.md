# Cadastro de Pessoas - JSF + PrimeFaces + JPA

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![JSF](https://img.shields.io/badge/JSF-2.2+-orange)
![PrimeFaces](https://img.shields.io/badge/PrimeFaces-10.0+-blue)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-13+-blue?logo=postgresql)
![Maven](https://img.shields.io/badge/Maven-3.6+-red?logo=apache-maven)

Sistema de cadastro de pessoas desenvolvido com Java EE, JSF, PrimeFaces e JPA/Hibernate.

## 📋 Funcionalidades

- ✅ CRUD completo de pessoas
- ✅ Gerenciamento de endereços
- ✅ Validação de formulários
- ✅ Interface responsiva
- ✅ Integração com PostgreSQL

## 🚀 Tecnologias Utilizadas

- **Frontend**: JSF + PrimeFaces 
- **Backend**: Java 17 EE 11  (EJBs)
- **Persistência**: JPA + Hibernate 
- **Banco de Dados**: PostgreSQL 
- **Build**: Maven 3.6+

## 🛠️ Configuração do Ambiente

### Pré-requisitos

- JDK 17+
- Maven 3.6+
- Servidor de Aplicação Java EE 11 (WildFly)
- PostgreSQL

### 🔧 Instalação

1. Clone o repositório:
   ```bash
   git clone https://github.com/seu-usuario/cadastro-pessoas.git
   cd cadastro-pessoas
   ```

2. Configure o banco de dados:
   ```sql
   CREATE DATABASE cadastro_pessoas;
   ```

3. Atualize as credenciais no `persistence.xml` 

4. Construa o projeto:
   ```bash
   mvn clean package
   ```

5. Implante o arquivo WAR no seu servidor de aplicação

## 🌐 Acessando a Aplicação

Após implantação, acesse:
```
http://localhost:8080/cadastro-pessoas/
```

## 🤝 Contribuição

Contribuições são bem-vindas! Siga os passos:

1. Faça um fork do projeto
2. Crie uma branch (`git checkout -b feature/nova-feature`)
3. Commit suas mudanças (`git commit -m 'Adiciona nova feature'`)
4. Push para a branch (`git push origin feature/nova-feature`)
5. Abra um Pull Request

## 📄 Licença

Este projeto está sob a licença MIT. Veja o arquivo [LICENSE](LICENSE) para mais detalhes.

## ✉️ Contato

Cayo Duarte Vidal - cayoduartevidal@gmail.com

Projeto Link: [https://github.com/seu-usuario/cadastro-pessoas](https://github.com/Cduartev/Desafio-Cadastro-de-pessoas)
