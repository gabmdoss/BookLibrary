# 📚 Estrutura do projeto

```text
demo/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── book.library.demo/
│   │   │       ├── controller/
│   │   │       │   └── BookController.java
│   │   │       │
│   │   │       ├── service/
│   │   │       │   └── BookService.java
│   │   │       │
│   │   │       ├── repository/
│   │   │       │   └── BookRepository.java
│   │   │       │
│   │   │       ├── model/
│   │   │       │   └── Book.java
│   │   │       │
│   │   │       ├── dto/
│   │   │       │   └── BookLido.java
│   │   │       │
│   │   │       └── DemoApplication.java
│   │   │
│   │   └── resources/
│   │       ├── application.properties
│   │       └── db/
│   │           └── migration/
│   │
│   └── test/
│
├── pom.xml
└── README.md
```

## 📂 Responsabilidade de cada pasta

### `controller/`

Responsável pelas **requisições HTTP** da API.

Exemplo:

```java
@PostMapping
```

O Controller recebe a requisição e chama o Service.

---

### `service/`

Onde ficam as **regras de negócio** da aplicação.

Exemplos:

* verificar se o livro já existe;
* validar alguma regra antes de salvar;
* decidir o que deve acontecer em determinada situação.

```text
Controller → Service
```

---

### `repository/`

Responsável pelo **acesso ao banco de dados**.

Normalmente utiliza o Spring Data JPA:

```java
public interface BookRepository extends JpaRepository<Book, Long> {
}
```

---

### `model/`

Contém as **Entities**, que representam os dados persistidos no banco.

Exemplo:

```text
Book → tabela livros
```

---

### `dto/`

Contém os objetos utilizados para **transportar dados** entre a API e a aplicação.

Exemplo:

```text
BookLido
```

O DTO não precisa ser igual à Entity.

---

### `resources/`

Contém arquivos de configuração e recursos da aplicação.

Principalmente:

```text
application.properties
```

que possui configurações do Spring, banco de dados, JPA, Flyway etc.

---

### `db/migration/`

Contém as **migrations do Flyway**.

Exemplo:

```text
V1__create_table_livros.sql
```

São os scripts responsáveis por criar ou alterar a estrutura do banco de forma versionada.

---

### `pom.xml`

Arquivo do **Maven**.

Define as dependências e configurações do projeto.

---

## 🔄 Fluxo da aplicação

```text
Requisição HTTP
       ↓
   Controller
       ↓
    Service
       ↓
   Repository
       ↓
   SQL Server
```

### Resumindo

| Pasta          | Responsabilidade              |
| -------------- | ----------------------------- |
| `controller`   | Receber requisições HTTP      |
| `service`      | Regras de negócio             |
| `repository`   | Acesso ao banco               |
| `model`        | Representar os dados/Entities |
| `dto`          | Transportar dados             |
| `resources`    | Configurações e recursos      |
| `db/migration` | Versionar alterações do banco |

> **Regra simples para lembrar:** Controller recebe → Service decide → Repository acessa o banco.
