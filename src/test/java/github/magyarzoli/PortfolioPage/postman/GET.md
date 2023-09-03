- [x] GET home is (200 OK)
```bash
curl --location 'http://localhost:8000'
```

- [x] GET about is (200 OK)
```bash
curl --location 'http://localhost:8000/about'
```

- [x] GET service is (200 OK)
```bash
curl --location 'http://localhost:8000/about#service'
```

- [x] GET portfolio is (200 OK)
```bash
curl --location 'http://localhost:8000/portfolio'
```

- [x] GET portfolio Sort Hierarchy is (200 OK)
- [x] GET portfolio Retro Casino Game is (200 OK)
- [x] GET portfolio File Handler is (200 OK)
- [x] GET portfolio Rotating Figure is (200 OK)
- [x] GET portfolio Junit Tutorial is (200 OK)
```bash
curl --location 'http://localhost:8000/portfolio/Sort%20Hierarchy'
curl --location 'http://localhost:8000/portfolio/Retro%20Casino%20Game'
curl --location 'http://localhost:8000/portfolio/File%20Handler'
curl --location 'http://localhost:8000/portfolio/Rotating%20Figure'
curl --location 'http://localhost:8000/portfolio/Age%20In%20Seconds'
curl --location 'http://localhost:8000/portfolio/Junit%20Tutorial'
```

- [x] GET portfolio AnotherRepo is (500 Internal Server Error)
```bash
curl --location 'http://localhost:8000/portfolio/AnotherRepo'
```

- [x] GET contact is (200 OK)
```bash
curl --location 'http://localhost:8000/contact'
```

- [x] GET error is (999 None)
```bash
curl --location 'http://localhost:8000/error'
```