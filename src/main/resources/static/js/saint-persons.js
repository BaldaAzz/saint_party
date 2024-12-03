const DOMEN = 'http://localhost:8080';

let currntPage = 0;


function renderCards(data) {
    const cardsList = document.querySelector('#card-list');
    const template = document.querySelector('#tmpCard');

    data.forEach(item => {
        const card = template.content.cloneNode(true);

        const saintName = card.querySelector('#saint-name');
        const dateOfBirth = card.querySelector('#date-of-birdth');
        const placeOfBirth = card.querySelector('#place-of-birth');
        const dateOfDeath = card.querySelector('#date-of-death');
        const typeOfFeat = card.querySelector('#type-of-feat');
        const rank = card.querySelector('#rank');
        const img = card.querySelector('#image');
        const viewButton = card.querySelector('#btn');

        if(item.imageUrl) {
            img.src = DOMEN + '/' + item.imageUrl;
        }
        else {
            img.src = item.imageUrl || '/img/no_photo.png';
        }

        saintName.textContent = item.surname + ' ' + item.name + ' ' + item.fathersName;
        dateOfBirth.textContent = item.dateOfBirth;
        placeOfBirth.textContent = item.region;
        dateOfDeath.textContent = item.dateOfDeath;
        typeOfFeat.textContent = item.typeOfFeat;
        rank.textContent = item.rank;

        viewButton.href = DOMEN + '/biography/' + item.id;

        cardsList.appendChild(card);
    });
}

function makeRequest(params) {
    console.log(DOMEN + '/api/biography/get' + params);
    return fetch(DOMEN + '/api/biography/get' + params)
        .then(response => response.json());
}

function resetCardList() {
    const cardsList = document.querySelector('#card-list');
    cardsList.innerHTML = '';
}

function generateRequest(filter) {
    let request = '';

    const rank = filter.querySelector('#rank').value;
    const region =  filter.querySelector('#region').value;
    const type = filter.querySelector('#type').value;

    
    const parametrs = new Array();

    parametrs.push('page=' + currntPage);

    if(rank != '') {
        parametrs.push('rank=' + rank);
    }

    if(region != '') {
        parametrs.push('region=' + region);
    }

    if(type != '') {
        parametrs.push('typeOfFeat=' + type);
    }

    if(parametrs.length != 0) {
        request += '?' + parametrs.join('&');
    }

    filterParams = request;

    return request
}

function randerPage(filter) {
    const requestParams = generateRequest(filter);
    resetCardList();
    makeRequest(requestParams).then(personsData => renderCards(personsData));
}

function onClickApplayFilter(filter) {
    currntPage = 0;
    randerPage(filter);
}

function onClickMovePreviousPage(filter) {
    if(currntPage <= 0) {
        return;
    }

    currntPage--;
    randerPage(filter);
}

function onClickMoveNextPage(filter) {
    currntPage++;

    const requestParams = generateRequest(filter);
    makeRequest(requestParams).then(data => {
        if(data.length == 0) {
            currntPage--;
            return;
        }

        randerPage(filter);
    });
}




const filter = document.querySelector('#filter');
const filterBtn = filter.querySelector('#filter-btn');

const pagination = document.querySelector('.pagination');
const previousBtn = pagination.querySelector('#previous');
const nextBtn = pagination.querySelector('#next');


filterBtn.addEventListener('click', () => onClickApplayFilter(filter));
previousBtn.addEventListener('click', () => onClickMovePreviousPage(filter));
nextBtn.addEventListener('click', () => onClickMoveNextPage(filter));

randerPage(filter);
