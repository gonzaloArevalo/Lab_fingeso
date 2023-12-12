
<template>
  <div>
    <h1 v-if="user" class="user-name">Bienvenid@ {{ this.user.nombre }}</h1>
    <p class="text-center">
      Usted acaba de ingresar en la plataforma. Esta diseñada con el fin de
      favorecer el uso simple de las cuentas de la comunidad establecida para
      que se tenga una experiencia más fluida.
    </p>
    <br />
    <br />
    <v-btn width="300" height="50" @click="Deudas()"> Deudas </v-btn>
  </div>
</template>

<script>
export default {
  layout: "layout2",
  name: "user2",
  data() {
    return {
      id: "",
      user: null,
    };
  },
  created() {
    this.user = this.$route.params.user;
    this.id = this.$route.params.user.id_residente;
  },
  methods: {
    async Deudas() {
      this.$router.push({ name: "deudas_r", params: { id: this.id } });
    },
  },
};
</script>

<style scoped>
.user-name {
  font-weight: bold;
  color: #3498db;
  margin-bottom: 45px;
}
.large-text {
  font-size: 50px;
}
</style>
