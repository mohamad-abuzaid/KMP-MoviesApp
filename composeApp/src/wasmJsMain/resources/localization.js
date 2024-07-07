function setLanguage(language) {
    document.documentElement.lang = language;
    // You can add additional logic to reload resources or refresh the UI
    if (language === 'ar') {
        document.body.style.direction = 'rtl';
    } else {
        document.body.style.direction = 'ltr';
    }
    console.log("Language set to:", language);
}