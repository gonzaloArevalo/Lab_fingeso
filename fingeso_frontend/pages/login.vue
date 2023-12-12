<template>
  <v-container fluid>
    <h1 v-if="tipoUsuario === 1" class="text-center" style="margin-bottom: 20px; margin-top: 20px;"> Admin Login </h1>
    <h1 v-if="tipoUsuario === 2" class="text-center" style="margin-bottom: 20px; margin-top: 20px;"> Residente Login </h1>
    <h1 v-if="tipoUsuario === 3" class="text-center" style="margin-bottom: 20px; margin-top: 20px;"> Subadmin Login </h1>
    <h1 v-if="tipoUsuario === 4" class="text-center" style="margin-bottom: 20px; margin-top: 20px;"> Personal Login </h1>
    <v-row justify="center" class="mt-10 mb-10">
      <v-col cols="12" sm="8" md="6">
        <v-card class="elevation-12 pa-8" outlined>
          <v-form @submit.prevent="iniciarSesion">
            <v-text-field v-model="correo" label="Correo" outlined required></v-text-field>
  
            <v-text-field v-model="contrasena" label="Contraseña" outlined type="password" required></v-text-field>
  
            <v-btn type="submit" color="primary" class="mt-4">Iniciar Sesión</v-btn>

            <!-- Mensaje de error -->
            <v-alert v-if="errorMensaje" type="error" class="mt-3">
              {{ errorMensaje }}
            </v-alert>
          </v-form>
        </v-card>
      </v-col>
    </v-row>
  </v-container>
</template>
  
<script>
export default {
  name: "login",
  layout: 'layout2',
  data() {
    return {
      tipoUsuario: this.$route.params.userType,
      correo: '',
      contrasena: '',
      user: null,
      errorMensaje: '', // Variable para almacenar el mensaje de error
    };
  },
  methods: {
    async autenticar(url) {
      try {
        const respuesta = await this.$axios.get(url);
        if (respuesta) {
          // Si la autenticación es exitosa, navegar a la página destino
          this.user = respuesta.data;
          switch (this.tipoUsuario) {
            case 1:
              this.$router.push({ name: 'user1', params: { user: this.user } });
              break;
            case 2:
            this.$router.push({ name: 'user2', params: { user: this.user } });
              break;
            case 3:
            this.$router.push({ name: 'user3', params: { user: this.user } });
              break;
            case 4:
            this.$router.push({ name: 'user4', params: { user: this.user } });
              break;
            default:
              break;
          }
        } else {
          // Mostrar mensaje de error si la autenticación falla
          this.errorMensaje = 'Correo o contraseña inválidos';
        }
      } catch (error) {
        console.error('Error durante la autenticación:', error);
        this.errorMensaje = 'Correo o contraseña inválidos';
      }
    },
    async iniciarSesion() {
      switch (this.tipoUsuario) {
        case 1:
          await this.autenticar("/admin/login/" + this.correo + "/" + this.contrasena);
          break;
        case 2:
          await this.autenticar("/residente/login/" + this.correo + "/" + this.contrasena);
          break;
        case 3:
          await this.autenticar("/subadmin/login/" + this.correo + "/" + this.contrasena);
          break;
        case 4:
          await this.autenticar("/personal/login/" + this.correo + "/" + this.contrasena);
          break;
        default:
          break;
      }
    },
  },
};
</script>