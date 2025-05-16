## API Contracts for URL Shortener

### **Create Short URL**

* **Endpoint:** `/api/v1/url`
* **Method:** POST
* **Request Body:**

```json
{
"longUrl": "https://example.com/some-long-url",
"customAlias": "optional-custom-name",
"expiryDate": "2025-12-31"
}
```
* **Response:**

```json
{
"shortUrl": "https://short.ly/abc123",
"expiryDate": "2025-12-31"
}
```
* **Error Responses:**

  * `400 Bad Request` → If the URL is invalid.
  * `409 Conflict` → If custom alias already exists.
  * `500 Internal Server Error` → If there is a server-side issue.

---

### **Get Original URL**

* **Endpoint:** `/api/v1/url/{shortUrl}`
* **Method:** GET
* **Path Parameter:**

  * `shortUrl`: The shortened URL identifier (e.g., `abc123`).
* **Response:**

```json
{
"longUrl": "https://example.com/some-long-url"
}
```
* **Error Responses:**

  * `404 Not Found` → If the short URL does not exist.
  * `410 Gone` → If the URL has expired.
  * `500 Internal Server Error` → If there is a server-side issue.

---

### **Get URL Analytics**

* **Endpoint:** `/api/v1/url/{shortUrl}/analytics`
* **Method:** GET
* **Path Parameter:**

  * `shortUrl`: The shortened URL identifier.
* **Response:**

```json
{
"clickCount": 120,
"locations": [
    { "country": "US", "count": 50 },
    { "country": "IN", "count": 30 }
],
"referrers": [
    { "source": "Twitter", "count": 40 },
    { "source": "Facebook", "count": 20 }
],
"lastAccessed": "2025-05-15T12:34:56Z"
}
```
* **Error Responses:**

  * `404 Not Found` → If the short URL does not exist.
  * `500 Internal Server Error` → If there is a server-side issue.

---

### **Rate Limiting and Security**

* All API endpoints are rate-limited to prevent abuse.
* Secure endpoints with JWT or API Key Authorization.
* HTTPS enforced for all requests.
