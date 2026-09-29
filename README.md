# Student Result Management System

A full-stack academic result portal built with **Spring Boot 3.3**, **Thymeleaf**, **Spring Security**, and **PostgreSQL**. Deployed on Render via Docker.

🔗 **Live**: [student-result-management-h02j.onrender.com](https://student-result-management-h02j.onrender.com)

---

## Features

- **3 Roles**: Admin, Teacher, Student — each with a dedicated dashboard
- **Result Workflow**: Draft → Published lifecycle before students can view results
- **SGPA & CGPA**: Auto-calculated from credit-weighted grade points
- **Bulk Upload**: Teachers upload student marks via `.xlsx` (Apache POI)
- **PDF Transcripts**: Students download semester result PDFs
- **Responsive UI**: Glassmorphism design with dark/light theme toggle
- **Security**: CSRF protection, BCrypt hashing, HttpOnly session cookies

---

## Tech Stack

| Layer | Technology |
|---|---|
| Backend | Java 21, Spring Boot 3.3 |
| Frontend | Thymeleaf, Vanilla JS, CSS3 |
| Security | Spring Security 6, BCrypt, CSRF tokens |
| Database | PostgreSQL (Spring Data JPA) |
| Excel | Apache POI 5.2.5 |
| PDF | OpenPDF 1.3.40 |
| Deployment | Docker (multi-stage), Render |

---

## Grading System

| Marks | Grade | Points |
|---|---|---|
| 90–100 | A+ | 10.0 |
| 80–89 | A | 9.0 |
| 70–79 | B | 8.0 |
| 60–69 | C | 7.0 |
| 50–59 | D | 6.0 |
| 0–49 | F | 0.0 |

**SGPA** = Σ(Grade Points × Credits) / Σ(Credits) per semester  
**CGPA** = Σ(Grade Points × Credits) / Σ(Credits) across all semesters

---

## Local Setup

**Prerequisites**: Java 21, Maven 3.9+, PostgreSQL 15+

```bash
# 1. Clone
git clone https://github.com/jprakash9938/Result_Management_System.git
cd Result_Management_System

# 2. Create database
createdb result_db

# 3. Configure .env in project root
DB_HOST=localhost
DB_PORT=5432
DB_NAME=result_db
DB_USER=postgres
DB_PASSWORD=yourpassword
SESSION_COOKIE_SECURE=false

# 4. Run
mvn spring-boot:run
```

App runs at `http://localhost:8080`. Tables are auto-created on first start.

---

## Deployment (Render)

1. Push code to GitHub.
2. Render Dashboard → **New +** → **Blueprint** → connect repo.
3. Render auto-detects `render.yaml` and provisions PostgreSQL + Web Service.
4. Every push to `main` triggers an automatic redeploy.

---

## Default Admin Login

On first startup, a default admin account is seeded automatically. Use it to create Teacher accounts and register Students.