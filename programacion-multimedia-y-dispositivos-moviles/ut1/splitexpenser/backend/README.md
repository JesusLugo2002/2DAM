# SplitExpenser Back-end

This is the back-end service for SplitExpenser, a web application that helps users manage and split expenses within groups. The service is built using Flask and SQLAlchemy.

# Setup

Excute the following commands to set up the development environment:

```bash
uv run python main.py
```

Or using Gunicorn for production:

```bash
gunicorn -w 4 -b 0.0.0.0:8000 main:app
```

# Testing

To run the test suite, use the following command:

```bash
uv run pytest
```