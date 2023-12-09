<template>
  <div>
    <h2>Login</h2>
    <form @submit.prevent="login">
      <label for="email">Correo:</label>
      <input v-model="loginRequest.email" type="text" id="email" required>
      <label for="password">Contraseña:</label>
      <input v-model="loginRequest.password" type="password" id="password" required>
      <button type="submit">Iniciar sesión</button>
      <p v-if="error" style="color: red;">{{ error }}</p>
    </form>
  </div>
</template>

<script>
export default {
  data() {
    return {
      loginRequest: {
        email: '',
        password: '',
      },
      error: null,
    };
  },
  methods: {
    async login() {
      try {
        const response = await this.$axios.post('/api/login', this.loginRequest);
        this.$router.push('/inicio');
      } catch (error) {
        console.error('Error al iniciar sesión:', error);
        this.error = 'Credenciales inválidas'; // Mensaje de error personalizado
      }
    },
  },
};
</script>
  