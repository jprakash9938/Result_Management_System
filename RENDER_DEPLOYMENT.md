# Deploying Student Result Management System to Render

This guide provides instructions for deploying your Spring Boot + PostgreSQL application to [Render](https://render.com) **with or without Docker**.

---

## Option 1: Native Java Deployment (Without Docker)

You can deploy directly using Render's native Java runtime environment without using Docker containers.

### Step-by-Step Manual Deployment:

#### 1. Create PostgreSQL Database on Render
1. Go to [Render Dashboard](https://dashboard.render.com/) -> **New +** -> **PostgreSQL**.
2. Set Name: `result-postgres-db`
3. Set Database Name: `result_db`
4. Set User: `result_user`
5. Click **Create Database**.
6. Note down the **Internal Database URL** and credentials from the details page.

#### 2. Create Native Java Web Service
1. Go to Render Dashboard -> **New +** -> **Web Service**.
2. Connect your GitHub/GitLab repository.
3. Choose **Native Java** (or Java) as the Environment / Runtime.
4. Set **Build Command**:
   ```bash
   mvn clean package -DskipTests
   ```
5. Set **Start Command**:
   ```bash
   java -jar target/student-result-management-0.0.1-SNAPSHOT.jar
   ```
6. Add the following **Environment Variables** in the Web Service settings:

| Variable Key | Value / Instructions |
|---|---|
| `DB_HOST` | Internal Database Host (e.g. `dpg-xxxx-a`) from PostgreSQL details page |
| `DB_PORT` | `5432` |
| `DB_NAME` | `result_db` |
| `DB_USER` | `result_user` |
| `DB_PASSWORD` | Password from PostgreSQL details page |
| `SESSION_COOKIE_SECURE` | `true` |

7. Click **Create Web Service**.

---

## Option 2: Automatic Blueprint Deployment (with `render.yaml`)

Render Blueprints automatically set up both the database and web service using [`render.yaml`](file:///d:/PROJECTS/Result/render.yaml).

1. Push your repository to GitHub / GitLab.
2. Go to Render Dashboard -> **New +** -> **Blueprint**.
3. Connect your repository. Render will auto-detect `render.yaml` and provision both the PostgreSQL service and Web Service automatically!

---

## Default Login Credentials

Upon startup, `DatabaseSeeder` automatically creates the default administrator account:
- **Username**: `admin`
- **Password**: `admin123`
