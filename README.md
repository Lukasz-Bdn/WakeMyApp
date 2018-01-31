# WakeMyApp

This application is deployed on <a href="https://wakemyapp.herokuapp.com/">https://wakemyapp.herokuapp.com/</a>

Heroku is a great platform, where anyone can easily deploy their application for free. There is only one downside: each application running on free dyno will go to sleep after 30 minutes of inactivity and every application needs to sleep for at least 6h per day. Next activity will "wake up" the application, but it can take 15-30. This can be enough for someone to assume website is not working and give up. Not ideal if this app is, for example, a part of your programming portfolio...

WakeMyApp application is providing an easy and convenient solution to that:

1. After creating user account, you can specify a website (it can be any valid website, not necessarily Heroku app).
2. WakeMyApp will send http request to this website every 20 minutes, in other words it will keep it "awake".
3. You can specify days and hours when you want to keep it active.

Technologies used in this project:
1. Java.
2. Spring (Boot, MVC, Security, Data).
3. Hibernate with PostgreSQL database (MySQL was also used, when setting the app locally).
4. Tools: Maven, GitHub, Eclipse (Spring Tool Suite).
5. HTML, JSP, CSS, Bootstrap.
