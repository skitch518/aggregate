# Personal Finance Aggregator

A backend REST API built with Java and Spring Boot that enables users to track portfolio holdings with real-time market data. The API exposes full CRUD endpoints for managing holdings and integrates the Finnhub API to fetch live market prices and calculate current portfolio value.

React frontend in progress.

## Tech Stack

- Java 21
- Spring Boot 3.5
- Spring Data JPA / Hibernate
- MySQL
- Finnhub API

## Features

- Create, read, update, and delete portfolio holdings
- Real-time market prices fetched from Finnhub on every request
- Current portfolio value calculated dynamically per holding

## Prerequisites

- Java 21
- MySQL

## Setup

1. Clone the repo
git clone https://github.com/skitch518/aggregate.git

2. Create the database in MySQL
```sql
   CREATE DATABASE aggregate;
```

3. Copy `.env.example` to `.env` and fill in your values
DB_PASSWORD=your_mysql_password
FINNHUB_API_KEY=your_finnhub_api_key

4. Run the app
.\gradlew.bat bootRun

5. API available at `http://localhost:8080`

## Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | /holdings | Get all holdings with live prices |
| POST | /holdings | Add a new holding |
| PUT | /holdings/{id} | Update a holding |
| DELETE | /holdings/{id} | Delete a holding |

## Coming Soon

- React frontend
- User authentication with Spring Security
- Total portfolio value endpoint
