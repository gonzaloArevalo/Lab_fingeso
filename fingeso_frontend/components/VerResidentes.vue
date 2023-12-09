<template>
    <v-container>
      <v-card class="mx-auto" max-width="600" height="400px">
        <v-card-title class="primary">
          <span class="headline">Residentes del edificio</span>
        </v-card-title>
  
        <v-card-text>
          <v-list>
            <v-list-item-group v-if="residentsWithPayments.length">
              <v-list-item
                v-for="(resident, index) in residentsWithPayments"
                :key="index"
              >
                <v-list-item-content>
                  <v-list-item-title>{{ resident.name }}</v-list-item-title>
                  <v-list-item-subtitle>{{ resident.apartment }}</v-list-item-subtitle>
                  <v-list-item-subtitle v-if="resident.paymentStatus === 'Atrasado'" class="red--text">Pago Atrasado</v-list-item-subtitle>
                </v-list-item-content>
              </v-list-item>
            </v-list-item-group>
            <v-list-item v-else>
              <v-list-item-content>No hay residentes con pagos atrasados.</v-list-item-content>
            </v-list-item>
          </v-list>
        </v-card-text>
      </v-card>
    </v-container>
  </template>
  
  <script>
  export default {
    data() {
      return {
        residentsWithPayments: [
          { name: 'Residente 1', apartment: '101', paymentStatus: 'Al día' },
          { name: 'Residente 2', apartment: '102', paymentStatus: 'Atrasado' },
          // Agrega más residentes según sea necesario
        ]
      };
    }
  };
  </script>
  
  <style>
  .primary {
    background-color: #1976d2;
    color: #ffffff;
  }
  
  .payment-overdue {
    background-color: #FFEBEE; /* Cambia el color de fondo para resaltar los pagos atrasados */
  }
  </style>
  