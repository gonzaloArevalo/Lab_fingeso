<template>
    <v-app>
      <v-container>
        <v-card>
          <v-card-title>Lista de Edificios</v-card-title>
  
          <v-list>
            <v-list-item-group v-for="edificio in edificios" :key="edificio.id">
              <v-list-item>
                <v-list-item-content>
                  <v-list-item-title>ID del Edificio: {{ edificio.id_edificio }}</v-list-item-title>
                  <v-list-item-subtitle>
                    Departamentos Totales: {{ edificio.departamentosTotales }}
                  </v-list-item-subtitle>
                  <v-list-item-subtitle>
                    Departamentos Ocupados: {{ edificio.departamentosOcupados }}
                  </v-list-item-subtitle>
                </v-list-item-content>
              </v-list-item>
            </v-list-item-group>
          </v-list>

        </v-card>
      </v-container>
    </v-app>
  </template>
  
  <script>
  import axios from 'axios';  
  export default {
    name: "edificios_a",
    data() {
      return {
        edificios: [],
      };
    },
    methods: {
        getData: async function(){
            const response = await axios.get("/edificio/getAll");
            this.edificios = response.data;
        }
    },
    created:function(){
      this.getData();
    },
};
</script>
  