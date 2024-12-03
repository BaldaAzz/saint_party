const tooltip = document.querySelector('.tooltip');
const points = document.querySelectorAll('.point');
const popupBg = document.querySelector('.info__bg');
const popup = popupBg.querySelector('.info');
const popupCloseBtn = popupBg.querySelector('.info__close-btn');

points.forEach(point => {
    point.addEventListener('click', function() {
        popup.querySelector('.info__photo').setAttribute('src', this.dataset.photo);
        popup.querySelector('.info__title').innerText = this.dataset.title;
        popup.querySelector('.info__text').innerText = this.dataset.text;
        popupBg.classList.add('active');
    });

    point.addEventListener('mousemove', function(e) {
        tooltip.innerText = this.dataset.title;
        tooltip.style.top = (e.clientY + 20) + 'px';
        tooltip.style.left= (e.clientX + 20) + 'px';

    });

    point.addEventListener('mouseenter', () => {
        tooltip.style.display = 'block';
    });

    point.addEventListener('mouseleave', () => {
        tooltip.style.display = 'none';
    });
})

document.addEventListener('click', (e) => {
    if(e.target === popupBg) {
        popupBg.classList.remove('active');
    }
});

popupCloseBtn.addEventListener('click', () => {
    popupBg.classList.remove('active');
});