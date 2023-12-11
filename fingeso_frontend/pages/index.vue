<template>
  <div>
    <h1>Login</h1>
    <v-form @submit.prevent="login">
      <v-text-field v-model="correo" label="Correo"></v-text-field>
      <v-text-field v-model="contrasenia" label="Contraseña" type="password"></v-text-field>
      <v-btn type="submit" color="primary">Iniciar sesión</v-btn>
    </v-form>
  </div>
</template>

<script>
export default {
  data() {
    return {
      correo: '',
      contrasenia: '',
    };
  },
  methods: {
    login() {
      console.log(this.correo);
      console.log(this.contrasenia);

      this.$axios.get(`/admin/login/${this.correo}/${this.contrasenia}`).then((response) => {
          console.log(response);
          // Aquí puedes redirigir a la página _id.vue con el ID del administrador
          this.$router.push({ path: "/_id/${response.data.id_admin}" });
        })
        .catch((error) => {
          console.error(error);
          // Manejar errores, por ejemplo, mostrar un mensaje al usuario
        });
    },
  },
};
</script>