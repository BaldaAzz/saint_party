fetch('http://localhost:8080/api/biography/get_all')
    .then(response => {
        if(!response.ok) {
            throw new Error("Error");
        }

        return response.json();
    })
    .then(data => {
        console.log(data);

        // Данные для отображения находятся в переменной data
        // Формат json
        
    })
    .catch(error => {
        console.error(error)
    });