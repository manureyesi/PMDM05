# PMDM05

## Diseño

Tratar de aproximarse aldiseño de las pantallas que se muestran a continuación.
  1.Posiciones de los elementos: 
    No se usó ningún margen, posición, etc. 
  2.Colores: 
    Se usaron colores básicos.
  
### Actividad Principal
  
- **Botón: "Provincia/Calculadora/Mail"**

  1. Si se hace Clicklanza una segunda activity en la que poder introducir la provincia delusuario.
  2. Si se hace un longClicklanza la calculadora u opcionalmente, en su lugar, lanza elprograma de mail pasándole destinatario, asunto ycuerpo del mensaje. En este último caso el estudiante deberáusar los recursos que interneto cualquier otra fuente ponga a su alcance.

- **Botón: "Provincia Usuario"**

  1. Si se hace Click  realiza  un  Toast mostrando  la provincia  indicada  por  el usuario en  la  actividad secundaria.
  2. Si se gira el dispositivo en apaisado y se vuelvea pulsar en el botón debe mostrar el mismo resultado que en vertical.

### Activity secundaria

- **EditText**: para solicitar la provincia al usuario.

- **Botón: Cerrar**:  realizar  lo  necesario  para  pasarle  la  provincia  indicada  por  el  usuario  a  la  activity llamadora y cierra la activity secundaria.

- Además de lo explicado anteriormente se debe de tener en cuenta lo siguiente:

  1. Sí se sale de la actividad secundaria sin pulsar el botón ‘Cerrar’ deberá mostrar un Toast como en la imagen.
  2. Sí se pulsa el botón ‘Provincia Usuario’ sin haber tecleado una provincia, se debe mostrar:

## Empaquetar y distribuir la aplicación

Generar un apk (mismo nombre que la app) firmado para distribuirla aplicación con contraseña: **abc123.**
