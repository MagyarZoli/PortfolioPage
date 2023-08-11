const header = document.querySelector("header");
const backToTop = document.getElementById("top");
const themeStyle = document.getElementById('theme-style');

const sr = ScrollReveal ({
    distance: '25px',
    duration: 2500,
    reset: true
});

let menu = document.querySelector('#menu-icon');
let navbar = document.querySelector('.navbar');
let delay = 190;

window.addEventListener("scroll", function() {
    header.classList.toggle("sticky", window.scrollY > 0);
    backToTop.classList.toggle("hide-top", window.scrollY <= 100);
});

menu.onclick = () => {
    menu.classList.toggle('bx-x');
    navbar.classList.toggle('active');
};

window.onscroll = () => {
    menu.classList.remove('bx-x');
    navbar.classList.remove('active');
};

sr.reveal('.home-text', {delay: delay, origin: 'bottom'});
sr.reveal('.about, .services, .portfolio, .contact', {delay: (delay + 10), origin: 'bottom'});

function themeChange() {
    if (themeStyle.getAttribute("href") === "css/light.css") {
        themeStyle.setAttribute("href", "css/dark.css");
        localStorage.setItem("theme", "dark");
    } else {
        themeStyle.setAttribute("href", "css/light.css");
        localStorage.setItem("theme", "light");
    }
}