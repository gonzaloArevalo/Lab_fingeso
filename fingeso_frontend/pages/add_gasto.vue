<template>
    <v-container fluid>
      <h1 class="text-center" style="margin-bottom: 20px; margin-top: 20px;"> Crear Gasto Común </h1>
      <v-row justify="center" class="mt-10 mb-10">
        <v-col cols="12" sm="8" md="6">
          <v-card class="elevation-12 pa-8" outlined>
            <v-form @submit.prevent="addGasto">
              <v-text-field v-model="desc" label="Descripción" outlined required></v-text-field>
              <v-text-field v-model="monto" label="Monto" outlined required></v-text-field>
              <v-btn type="submit" color="primary" class="mt-4">Añadir Gasto</v-btn>
            </v-form>
          </v-card>
        </v-col>
      </v-row>
    </v-container>
  </template>
  
  <script>
  import axios from 'axios';
  export default {
    name: 'add_gasto',
    layout: 'layout2',
    data() {
      return {
        id: this.$route.params.id,
        desc: '',  // Define la variable desc en el bloque data
        monto: '', // Define la variable monto en el bloque data
      };
    },
    methods: {
      async addGasto() {
        const response = await this.$axios.post("/gastoComun/addGasto/" + this.id + "/" + this.monto + "/" + this.desc);
        this.$router.push({name: 'edificios_a'});
      },
    },
  };
  </script>