# 🦉 Duolingo Clone – Microservices Fullstack App

Một dự án học ngôn ngữ mô phỏng Duolingo, được phát triển theo kiến trúc microservices hiện đại, sử dụng Spring Boot, PostgreSQL, RabbitMQ, Redis, ELK, NextJS, Prometheus, Grafana, Docker và CI/CD GitHub.

---

## 🏗️ Kiến trúc tổng quan

### 📦 duolingo-app/
```plaintext
duolingo-app/
├── frontend/                 # Next.js + Clerk (Auth UI)
├── backend/
│   ├── api-gateway/          # Spring Cloud Gateway
│   ├── discovery-server/     # Eureka (Service Registry)
│   ├── config-server/        # Spring Cloud Config
│   ├── course-service/       # Quản lý khóa học, units, lessons
│   ├── challenge-service/    # Câu hỏi, tùy chọn
│   ├── progress-service/     # Tiến độ người học
│   ├── subscription-service/ # Gói học Stripe
│   └── config/               # Các file YAML cho config-server
├── .env                      # Biến môi trường cho toàn hệ thống
├── docker-compose.yml        # Compose toàn hệ thống
├── .github/workflows/        # CI/CD pipelines
```
---

## 🧱 Công nghệ sử dụng

### 💻 Frontend
- [Next.js](https://nextjs.org/), [TailwindCSS](https://tailwindcss.com/)
- [Clerk.dev](https://clerk.dev/) – Xác thực người dùng
- TypeScript, REST API, Zustand

### 🔧 Backend (Microservices)
- Java 21 + Spring Boot 3
- Spring Cloud: Gateway, Eureka, Config Server
- Spring Data JPA, Spring AMQP (RabbitMQ)
- PostgreSQL (mỗi service có DB riêng)
- Redis (caching / leaderboard / rate-limit)
- Stripe API (Subscription Payment)

### 📦 DevOps
- Docker, Docker Compose
- CI/CD: GitHub Actions
- Config Central: Spring Cloud Config + Git

### 🔍 Monitoring & Logging
- **Prometheus** + **Grafana** (metrics)
- **ELK stack**: Elasticsearch + Logstash + Kibana (logs)
- Actuator + Micrometer

---

## ⚙️ Cách chạy dự án

### 1. Clone repository
```bash
git clone https://github.com/quocnhat02/duolingo-app.git
cd duolingo-app
```

### 2. Tạo .env từ mẫu
```bash
docker-compose up --build
```

---

## 📂 Cấu trúc backend/config/
```text
/backend/config/
├── application.yml
├── course-service.yml
├── challenge-service.yml
├── progress-service.yml
├── subscription-service.yml
├── gateway-service.yml
```
---
## 🔐 Authentication (Clerk)
* ### Frontend sử dụng Clerk để xác thực người dùng (OAuth2, Email)

* ### Backend sử dụng JWT để kiểm tra userId từ Clerk
---
## 💳 Thanh toán (Stripe)
* ### Người dùng có thể nâng cấp gói học (Subscription)

* ### Stripe integration backend: subscription-service

* ### Webhook handler để xác nhận trạng thái
---
## 📊 Monitoring & Logging
| Công cụ       | 	Mục đích     | 
|-------------|-------------|
| Prometheus | Thu thập metric từ actuator | 
| Grafana | Xem biểu đồ realtime CPU, Memory, TPS... | 
| Prometheus | Thu thập metric từ actuator | 
| Logstash | Đọc log từ container gửi về Elasticsearch | 
| Kibana | Dashboard truy vết log từng service | 

---
## 🔄 CI/CD với GitHub Actions
* ### Build & test từng service

* ### Build Docker images và push lên Docker Hub

```yaml
# .github/workflows/build.yml
name: Build & Deploy
on:
  push:
    branches: [main]
jobs:
  build:
    ...
```
---
## 👤 Tác giả
* ### Nguyen Quoc Nhat – [@quocnhat02](https://github.com/quocnhat02)
---
## 📄 License
* ### MIT License
