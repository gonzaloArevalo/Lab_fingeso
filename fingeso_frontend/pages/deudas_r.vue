<template>
    <div class="container">
        <div class="col-sm">
          <h1> Lista de Deudas</h1>
          <v-btn class="large-text" width="300" height="50" @click="Pagar">
            Pagar
          </v-btn>
          <table>
            <tr>
              <th>Montos</th>
              <th>Fechas</th>
            </tr>
            <tr v-for="(item, index) in items" :key="index">
              <td class="center-cell-text">
                <button><span>{{ item.monto }} </span></button>
              </td>
              <td class="center-cell-text">
                <span>{{obtenerFecha()}}</span>
              </td>
            </tr>
          </table>
        </div>
    </div>
</template>

<script>


//import axios from "axios";
export default {
    layout: 'layout2',
    //Función que contiene los datos del componente
    data() {
        return {
            //Lista de ítelass="big-numberms a mostrar
            items: []
        }
    },
    methods: {
        //Función asíncrona para consultar los datos
        getData: async function () {
            try {
                let response = await this.$axios.get('/deuda/getAll');
                this.items = response.data;
                console.log(response);
            } catch (error) {
                console.log('error', error);
            }
        },
        Pagar(){
            console.log("Pagar");
            window.open('https://login.portal.bancochile.cl/bancochile-web/persona/login/#/login', '_blank');
        },
        obtenerFecha() {
          const dueDate = new Date();
          dueDate.setMonth(dueDate.getMonth() + 1);
          dueDate.setDate(1);
          return dueDate.toLocaleDateString();
        },
    },
    //Función que se ejecuta al cargar el componente
    created () {
        this.getData();
    }

}
</script>
<style>
.container {
    display: flex;
    flex-direction: column;
    justify-content: center;
    /* align-items: center; */
}

.center-cell-text {
  text-align: center;
}

table {
  border-collapse: collapse;
  width: 100%;
  max-width: 1000px;
  margin-top: 50px;
}
tr{
  height: 60px;
}

th, td {
  border: 1px solid black;
}
.large-text {
  font-size: 50px;
}
</style>
