<template>
    <v-container>
      <v-card class="mx-auto" max-width="400" height="400px">
        <v-card-title class="primary">
          <span class="headline">Registrar a un nuevo residente</span>
        </v-card-title>
  
        <v-card-text>
          <v-form @submit.prevent="registerUser">
            <v-text-field
              v-model="userData.name"
              label="Nombre"
              required
            ></v-text-field>
  
            <v-text-field
              v-model="userData.email"
              label="Correo electrónico"
              required
              type="email"
            ></v-text-field>
  
            <v-text-field
              v-model="userData.password"
              label="Contraseña"
              required
              type="password"
            ></v-text-field>
  
            <v-text-field
              v-model="userData.confirmPassword"
              label="Confirmar Contraseña"
              required
              type="password"
            ></v-text-field>
  
            <v-btn type="submit" color="primary">Registrar</v-btn>
          </v-form>
        </v-card-text>
      </v-card>
    </v-container>
  </template>
  
  <script>
  export default {
    data() {
      return {
        userData: {
          name: '',
          email: '',
          password: '',
          confirmPassword: ''
        }
      };
    },
    methods: {
      registerUser() {
        // Aquí puedes realizar la lógica para registrar al usuario
        console.log('Datos del usuario:', this.userData);
      }
    }
  };
  </script>
  
  <style>
  .primary {
    background-color: #1976d2;
    color: #ffffff;
  }
  </style>
  