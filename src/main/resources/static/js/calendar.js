const calendars = document.querySelectorAll('.mounth-calendar');
const tooltip = document.querySelector('.tooltip');
const popupBg = document.querySelector('.info__bg');
const popup = popupBg.querySelector('.info');
const popupCloseBtn = popupBg.querySelector('.info__close-btn');

calendars.forEach((calendar) => {
    const activeDates = calendar.querySelectorAll('.active-day');

    activeDates.forEach(date => {
        date.addEventListener('mousemove', function(e) {
            tooltip.innerText = this.dataset.title;
            tooltip.style.top = (e.clientY + 15) + 'px';
            tooltip.style.left= (e.clientX + 15) + 'px';
    
        });
    
        date.addEventListener('mouseenter', () => {
            tooltip.style.display = 'block';
        });
    
        date.addEventListener('mouseleave', () => {
            tooltip.style.display = 'none';
        });


        date.addEventListener('click', function() {
            // popup.querySelector('.info__photo').setAttribute('src', this.dataset.photo);
            popup.querySelector('.info__title').innerText = this.dataset.title;
            popup.querySelector('.info__text').innerText = this.dataset.text;
            popupBg.classList.add('active');
            console.log('click');
        });
    })
});

document.addEventListener('click', (e) => {
    if(e.target === popupBg) {
        popupBg.classList.remove('active');
    }
});

popupCloseBtn.addEventListener('click', () => {
    popupBg.classList.remove('active');
});