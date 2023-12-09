<template>
    <v-container>
       <v-data-table :headers="headers" :items="administradores" class="elevation-1">
         <template v-slot:item.acciones="{ item }">
           <v-btn text color="primary" @click="editAdministrador(item.id)">
             Editar
           </v-btn>
           <v-btn text color="error" @click="deleteAdministrador(item.id)">
             Eliminar
           </v-btn>
         </template>
       </v-data-table>
    </v-container>
   </template>
   
   <script>
   import axios from 'axios'
   
   export default {
    data() {
       return {
         headers: [
           { text: 'ID', value: 'id' },
           { text: 'Nombre', value: 'nombre' },
           { text: 'Correo', value: 'correo' },
           { text: 'Acciones', value: ':acciones' },
         ],
         administradores: [],
       }
    },
    async created() {
       try {
         const response = await axios.get('/admin/')
         console.log(response)
         this.administradores = response.data
       } catch (error) {
         console.error(error)
       }
    },
    methods: {
       editAdministrador(id) {
         // ... Implementar la lógica para editar un administrador
       },
       deleteAdministrador(id) {
         // ... Implementar la lógica para eliminar un administrador
       },
    },
   }
   </script>