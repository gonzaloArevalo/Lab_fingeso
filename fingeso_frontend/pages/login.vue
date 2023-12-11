<template>
    <v-container fluid>
      <v-row justify="center">
        <v-col cols="12" sm="8" md="6">
          <v-card class="elevation-12 pa-8" outlined>
            <v-form @submit.prevent="iniciarSesion">
              <v-text-field v-model="correo" label="Correo" outlined required></v-text-field>
  
              <v-text-field v-model="contrasena" label="Contraseña" outlined type="password" required></v-text-field>
  
              <v-btn type="submit" color="primary" class="mt-4">Iniciar Sesión</v-btn>
            </v-form>
          </v-card>
        </v-col>
      </v-row>
    </v-container>
  </template>
  
  <script>
  export default {
    data() {
      return {
        correo: '',
        contrasena: '',
        admin: null,
      };
    },
    methods: {
      async iniciarSesion() {
        try {
          // Lógica de autenticación (puedes usar Vuex, una API, etc.)
          const respuesta = await this.$axios.get("/admin/login/" + this.correo + "/" + this.contrasena);
          // Si la autenticación es exitosa, navegar a la página destino
          if (respuesta) {
            this.admin = respuesta.data;
            this.$router.push({ name: 'prueba', params: { correo: this.correo, contrasena: this.contrasena } });
          } else {
            // Mostrar mensaje de error si la autenticación falla
            this.$vuetify.snackbar.error('Correo o contraseña inválidos');
          }
        } catch (error) {
          console.error('Error durante la autenticación:', error);
        }
      },
    },
  };
  </script>
  
  <style scoped>
  /* Agrega estilos personalizados aquí si es necesario */
  </style>