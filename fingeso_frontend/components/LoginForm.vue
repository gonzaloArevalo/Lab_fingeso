<template>
    <div class="container">
      <div class="screen">
        <div class="screen__content">
          <form class="login">
            <!-- <div class="login__field">
              <i class="login__icon fas fa-user"></i>
              <input v-model="username" type="text" class="login__input" placeholder="User name / Email">
            </div>
            <div class="login__field">
              <i class="login__icon fas fa-lock"></i>
              <input v-model="password" type="password" class="login__input" placeholder="Password">
            </div> -->
            <div class="login-form">
              <!-- Add your login form elements here -->
              <v-text-field v-model="username" label="Username/Email"></v-text-field>
              <v-text-field v-model="password" label="Password" type="password"></v-text-field>
              <v-btn @click="login">Login</v-btn>
            </div>
            <!-- <button @click.prevent="login" class="button login__submit">
              <span class="button__text">Log In Now</span>
              <i class="button__icon fas fa-chevron-right"></i>
            </button>	 -->			
          </form>
          <!-- <div class="social-login">
            <h3>log in via</h3>
            <div class="social-icons">
              <a href="#" class="social-login__icon fab fa-instagram"></a>
              <a href="#" class="social-login__icon fab fa-facebook"></a>
              <a href="#" class="social-login__icon fab fa-twitter"></a>
            </div>
          </div> -->
        </div>
        <div class="screen__background">
          <span class="screen__background__shape screen__background__shape4"></span>
          <span class="screen__background__shape screen__background__shape3"></span>		
          <span class="screen__background__shape screen__background__shape2"></span>
          <span class="screen__background__shape screen__background__shape1"></span>
        </div>		
      </div>
    </div>
  </template>
  
  <script>
  export default {
    data() {
      return {
        username: '',
        password: ''
      };
    },
    methods: {
      /* login() {
        // Implement your login logic here
        console.log('Logging in with:', this.username, this.password);
      } */
      async login() {
        try {
          // Replace the following with your actual login API call or authentication logic
          const response = await this.$axios.post('/api/login', {
            username: this.username,
            password: this.password,
          });

          // Assuming the server responds with a success message
          if (response.data.success) {
            // Redirect to the home page after successful login
            this.$router.push('/');
          } else {
            // Handle login failure, show an error message, etc.
            console.error('Login failed:', response.data.message);
          }
        } catch (error) {
          // Handle any errors that occurred during the login request
          console.error('Error during login:', error.message);
        }
      }
    }
  };
  </script>
  
  <style scoped>
  /* Add your component-specific styles here */
  .login-page {
  background: url('https://wallpaperaccess.com/full/4893732.jpg') center center/cover;
  height: 100vh; /* Adjust to cover the full viewport height */
  display: flex;
  align-items: center;
  justify-content: center;
}

.login-form {
  background-color: rgba(255, 255, 255, 0.8); /* Adjust the background color and transparency */
  padding: 20px;
  border-radius: 8px;
  box-shadow: 0 0 10px rgba(223, 0, 0, 0.2); /* Add a subtle box shadow */
}
  </style>
  