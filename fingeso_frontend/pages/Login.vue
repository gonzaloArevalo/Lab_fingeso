<!-- pages/LoginPage.vue -->

<template>
    <div>
      <LoginForm />
    </div>
  </template>
  
  <script>
  import LoginForm from '~/components/LoginForm.vue';  // Adjust the path based on your project structure
  
  export default {
    name: 'LoginPage',
    components: {
      LoginForm,
    },
  };
  </script>
  
  <style scoped>
  /* Add your page-specific styles here */
  </style>
  