package proyecto1sopes1;
class proceso {
    //datos de un proceso
    private String Nombre, Estado;
    private int UID, Memoria, timerInternoParaAsignarAMemoria;

    //tiempo de asignacion (inicializar)
    public int getTimerInternoParaAsignarAMemoria() {
        return timerInternoParaAsignarAMemoria;
    }
    //tiempo de asignacion settear de ventana aplicacion
    public void setTimerInternoParaAsignarAMemoria(int timerInternoParaAsignarAMemoria) {
        this.timerInternoParaAsignarAMemoria = timerInternoParaAsignarAMemoria;
    }
    //para el tiempo de vida
    public void disminuirTimer(){
        this.timerInternoParaAsignarAMemoria--;
    }
    //timer random para dar proceso    
    public proceso(){
        int min = 1;
        int max = 2;
        timerInternoParaAsignarAMemoria = (int) Math.floor(Math.random() * (max - min + 1) + min);
    }
    //datos para crear un nuevo objeto proceso
    public proceso copia(proceso otro){
        proceso nuevoproceso = new proceso();
        nuevoproceso.Nombre = otro.Nombre;
        nuevoproceso.UID = otro.UID;
        nuevoproceso.Estado = otro.Estado;
        nuevoproceso.Memoria = otro.Memoria;
        nuevoproceso.timerInternoParaAsignarAMemoria = otro.timerInternoParaAsignarAMemoria;
        return nuevoproceso;
    }
//getters y setters
    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public int getUID() {
        return UID;
    }

    public void setUID(int UID) {
        this.UID = UID;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public int getMemoria() {
        return Memoria;
    }

    public void setMemoria(int Memoria) {
        this.Memoria = Memoria;
    }
}
