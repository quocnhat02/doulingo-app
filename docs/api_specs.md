# 📘 Duolingo Clone - API Specification

## ✅ Authentication

- All APIs below require the user to be authenticated as an **Admin** (checked via `isAdmin()`).
- `401 Unauthorized`: when token/session is missing
- `403 Forbidden`: when user is not an admin
- Stripe webhook is authenticated using Stripe signature headers.

---

## 📚 Courses

### `GET /api/courses`

- **Description**: Get all courses
- **Auth**: Admin only
- **Response**: `200 OK` – Array of courses

### `POST /api/courses`

- **Description**: Create new course
- **Auth**: Admin only
- **Body**:

```json
{
  "title": "Learn Spanish",
  "imageSrc": "/images/spanish.png"
}
```

- **Response**: `200 OK` – Created course

### `GET /api/courses/{courseId}`

- **Description**: Get course by ID
- **Auth**: Admin only
- **Response**: `200 OK` – Single course

### `PUT /api/courses/{courseId}`

- **Description**: Update course by ID
- **Auth**: Admin only
- **Body**: Partial update allowed

```json
{
  "title": "Updated Title"
}
```

- **Response**: `200 OK` – Updated course

### `DELETE /api/courses/{courseId}`

- **Description**: Delete course by ID
- **Auth**: Admin only
- **Response**: `200 OK` – Deleted course

---

## 🧹 Units

### `GET /api/units`

- **Description**: Get all units
- **Auth**: Admin only

### `POST /api/units`

```json
{
  "title": "Unit 1",
  "description": "Introduction to Spanish",
  "courseId": 1,
  "order": 1
}
```

### `GET /api/units/{unitId}`

- **Description**: Get unit by ID

### `PUT /api/units/{unitId}`

```json
{
  "title": "Updated Title"
}
```

### `DELETE /api/units/{unitId}`

---

## 📗 Lessons

### `GET /api/lessons`

- **Description**: Get all lessons
- **Auth**: Admin only

### `POST /api/lessons`

```json
{
  "title": "Lesson 1",
  "unitId": 1,
  "order": 1
}
```

### `GET /api/lessons/{lessonId}`

### `PUT /api/lessons/{lessonId}`

```json
{
  "title": "Updated Lesson"
}
```

### `DELETE /api/lessons/{lessonId}`

---

## 🧠 Challenges

### `GET /api/challenges`

- **Description**: List all challenges

### `POST /api/challenges`

```json
{
  "lessonId": 1,
  "type": "SELECT",
  "question": "What does 'Hola' mean?",
  "order": 1
}
```

### `GET /api/challenges/{challengeId}`

### `PUT /api/challenges/{challengeId}`

```json
{
  "question": "Updated question?"
}
```

### `DELETE /api/challenges/{challengeId}`

---

## 🔸 Challenge Options

### `GET /api/challengeOptions`

- **Description**: List all challenge options

### `POST /api/challengeOptions`

```json
{
  "challengeId": 1,
  "text": "Hello",
  "correct": true,
  "imageSrc": "/images/hello.png",
  "audioSrc": "/audio/hello.mp3"
}
```

### `GET /api/challengeOptions/{challengeOptionId}`

### `PUT /api/challengeOptions/{challengeOptionId}`

```json
{
  "correct": false
}
```

### `DELETE /api/challengeOptions/{challengeOptionId}`

---

## 💳 Stripe Webhook

### `POST /api/webhooks/stripe`

- **Description**: Stripe webhook to handle subscription updates

- **Authentication**: Stripe-Signature header

- **Events handled**:

    - `checkout.session.completed`: Create user subscription
    - `invoice.payment_succeeded`: Update subscription period

- **Headers**:

    - `Stripe-Signature: <signature>`

---

## 🛡 Status Codes

- `200 OK`: Successful operation
- `400 Bad Request`: Invalid payload or Stripe signature
- `401 Unauthorized`: Not logged in or invalid session
- `403 Forbidden`: Not an admin
- `404 Not Found`: Resource not found (if handled)

