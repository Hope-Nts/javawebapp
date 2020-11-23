document.getElementById("defaultOpen").click();
var proLinks = document.getElementById("profile-links");
var navbar = document.getElementById("navbar");
var sticky = navbar.offsetTop;

window.onscroll = function () {
  show();
};
function show(links) {}

function hide(links) {
  links.classList.add("profile-links-hide");
  links.classList.remove("profile-links-show");
}

//sticky menu function
function stckTheNav() {
  if (window.pageYOffset >= sticky) {
    navbar.classList.remove("mav-bar");
    navbar.classList.add("sticky");
  } else {
    navbar.classList.remove("sticky");
    navbar.classList.add("nav-bar");
  }
}

//sign up tabs functionality

function showUserForm(evt, userType) {
  var i, signUpForm, tabButtons;

  signUpForm = document.getElementsByClassName("signUpForm");
  for (i = 0; i < signUpForm.length; i++) {
    signUpForm[i].style.display = "none";
  }

  tabButtons = document.getElementsByClassName("tabButtons");
  for (i = 0; i < tabButtons.length; i++) {
    tabButtons[i].className = tabButtons[i].className.replace("active", "");
  }
  document.getElementById(userType).style.display = "block";
  evt.currentTarget.className += "active";
}
