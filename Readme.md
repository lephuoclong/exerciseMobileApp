	install "adobe XD" to open file *.xd and "Figma" to open file *.fig: get the layout, image, icon...
Version 1: 
	1. create and handle activities
	- MainActivity : display  SplashLayout with prorgessBar in 2s. Then redirect to welcomeLayout
	- WelcomeActivity: + login : redirect to loginLayout
				+ signin: redirect to signLayout
	- LoginActivity and SignActivity: + wrong: toast message error
						+ correct: toast message success, then redirect to onboarding(HomeActivity)
	- HomeActivity: display HomeLayout
	
	link video : https://www.youtube.com/watch?v=cwUAKYkXRKk
