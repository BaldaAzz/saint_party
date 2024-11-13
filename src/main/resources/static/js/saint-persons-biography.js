const DOMEN = 'http://localhost:8080'


fetch(DOMEN + '/api/biography/get') // Замените на URL вашего API
    .then(response => {
        if (!response.ok) {
            throw new Error('Сеть не отвечает или произошла ошибка на сервере');
        }
        return response.json(); // Преобразуем ответ в JSON
    })
    .then(data => {

        console.log(data);

        const container = document.getElementById('cardContainer');
        const template = document.getElementById('cardTemplate');

        data.forEach(item => {
            const card = template.content.cloneNode(true);
            const cardText = card.querySelector('.card-text');
            const img = card.querySelector('img');
            const viewButton = card.querySelector('.btn');

            cardText.textContent = `${item.name} ${item.surname} (${item.rank}) - ${item.biography}`;
            if(item.imageUrl) {
                img.src = DOMEN + '/' + item.imageUrl
            }
            else {
                img.src = item.imageUrl || '/img/no_photo.png';
            }
            
            console.log(viewButton);
            viewButton.href = DOMEN + '/biography/' + item.id;

            container.appendChild(card);
        });
    })
    .catch(error => {
        console.error('Ошибка:', error); // Обработка ошибок
    });