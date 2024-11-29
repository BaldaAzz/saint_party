const DOMEN = 'http://localhost:8080';

let size = 100;

fetch(DOMEN + '/api/biography/get?size=' + size) // Замените на URL вашего API
    .then(response => {
        if (!response.ok) {
            throw new Error('Сеть не отвечает или произошла ошибка на сервере');
        }
        return response.json(); // Преобразуем ответ в JSON
    })
    .then(data => {
        renderCards(data);
    })
    .catch(error => {
        console.error('Ошибка:', error); // Обработка ошибок
    });


function renderCards(data) {
    console.log(data);

    const container = document.getElementById('cardContainer');
    const template = document.getElementById('cardTemplate');

    data.forEach(item => {
        const card = template.content.cloneNode(true);
        const dateOfBirdth = card.querySelector('.date-of-birdth');
        const placeOfBirth = card.querySelector('.place-of-birth');
        const dateOfDeath = card.querySelector('.date-of-death');
        const palceOfDeath = card.querySelector('.place-of-death');
        const dateOfMemory = card.querySelector('.date-of-memory');
        const img = card.querySelector('img');
        const viewButton = card.querySelector('.btn');

        if(item.imageUrl) {
            img.src = DOMEN + '/' + item.imageUrl;
        }
        else {
            img.src = item.imageUrl || '/img/no_photo.png';
        }

        dateOfBirdth.textContent = item.dateOfBirdth;
        placeOfBirth.textContent = item.placeOfBirth;
        dateOfDeath.textContent = item.dateOfDeath;
        palceOfDeath.textContent = item.palceOfDeath;
        dateOfMemory.textContent = item.dateOfMemory;

        viewButton.href = DOMEN + '/biography/' + item.id;

        container.appendChild(card);
    });
}


const filter = document.querySelector('#filter');
const rankValue = filter.querySelector('#rank');
const regionValue = filter.querySelector('#region');
const typeValue = filter.querySelector('#type');

const submitBtn = filter.querySelector('#submit-btn');



