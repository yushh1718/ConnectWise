console.log("script loaded");

/* change theme work */
let currentTheme = getTheme();
document.addEventListener('DOMContentLoaded', () => {
    changeTheme();
})

function changeTheme() {
    // set to web page
    changePageTheme(currentTheme, currentTheme);

    /* an event listener is a function (or code block) that waits for a specific event to occur and then executes a callback function in response, allowing you to make your webpage interactive. */

    // set the listner to change theme with button 
    const changeThemeButton = document.querySelector('#theme_change_button');
    
    const oldTheme = currentTheme;

    changeThemeButton.addEventListener("click", (event)=> {
        console.log("button clicked");
        const oldTheme = currentTheme;
        currentTheme = currentTheme === "dark" ? "light" : "dark";
        
        changePageTheme(currentTheme, oldTheme);
    });
}

// set theme to local storage
function setTheme(theme){
    localStorage.setItem("theme", theme);
}

// get theme from local storage
function getTheme(){
    let theme = localStorage.getItem("theme");
    return theme ? theme : 'light';
}

// change current page theme
function changePageTheme(theme, oldTheme){
    // update in local storage
    setTheme(currentTheme);
    // remove the current theme
    document.querySelector("html").classList.remove(oldTheme);
    // set the current theme
    document.querySelector("html").classList.add(theme);
    document.querySelector('#theme_change_button').querySelector("span").textContent =  theme == "light" ? "Dark" : "Light";

}
/* end of change theme work */
