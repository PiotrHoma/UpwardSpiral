

# UpwardSpiral
The Upward Spiral is a project that aims to help people to improve life by providing convenient way to manage and evaluate daily activities and aspiration. It's an online tool, based on psychotherapeutic techniques of making incremental changes for exponential grow in most life domains.

## See it in action
Working app can be found here:

https://upwordspiral.herokuapp.com

If you don't want to create an account just type "**guest**" in both input fields.

## Current state of development:
The Upward Spiral lets you set goals, describe them, score your daily progress on a five step scale and view your progress on a chart.

## What's next?
- Integration of asynchronous requests with Ajax for enhancement of the UX. The aim is to let user work with goals more fluently, on a one page without the necessity of reloading or changing the webpage.
- Develop graph and it's function. To show correlation in progress between many goals.
- Minor changes (pop-ups, email sending, password recovery).

## What tools were used?
Spring Boot 2.1, Spring Security, Thymeleaf, Maven, Hibernate, MySQL database. Logo and animated character done in Adobe Illustrator, for animation SVGator.

## Important Notes:
If you want to try this app locally you need to create database schema (e.g. Using MySQL workbench) then edit the application.property file accordingly. Next you need to put manually this line of code to your database.
>INSERT INTO `role` VALUES (1,'USER');

Otherwise registered user won't be able to log in because of the lack of role that grands access to the application.
"# UpwardSpiral" 
