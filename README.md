<h3>Taller de modelo y validación</h3>
<h4>Arquitectura de MicroServicios</h4>

Se implementó una arquitectura de micro servicios, pensando en el desacoplamiento y responsabilidad única, buscando una solución acorde a la necesidad del Banco ABC. 

La arquitectura se soporta en diferentes patrones, los cuales son:
<ul>
  <li><strong>Pattern: Service registry</strong>
Se realiza el descubrimiento de los servicios mediante API swaggers con especificación open api 3.0. Permitiendo al cliente acceder a las diferentes operaciones expuestas, contratos, y esquemas.</li>
  
<li><strong>Pattern: Database per service</strong>
Se implementan base de datos por servicio, obligando a que cualquier necesidad de acceso a sus datos se realice por un único servicio. </li>
<li><strong>Pattern: Service instance per container</strong>
Se crean contenedores docker independientes para cada servicio, orquestados por kubernetes.</li>
<li><strong>Pattern: API Gateway </strong>
Se realiza la implementación de un API Gateway, con swagger hub. Permitiéndonos acceder desde un solo punto a los diferentes servicios expuestos por el Banco ABC.</li>
<li><strong>Pattern: API Composition</strong>
Se implementa un servicio que se comporta como api composition, donde el api consulta los diferentes servicios y retorna la unión de las repuestas. Permitiendo hacer una composición por orquestación.  </li>
<li><strong>Pattern: Proxy</strong>
Se implementa el patrón proxy, en el servicio de transformación de XML y JSON. Permitiendo delegar la responsabilidad del manejo de excepciones presentadas.</li>
<li><strong>Pattern: Intermediate Routing</strong>
Se realiza el enrutamiento de acuerdo a las referencias enviadas por los clientes, permitiéndonos saber cuál es el convenio y así el servicio a invocar.</li>
<li><strong>Pattern: Dependency injection</strong>
La creación de objetos entre capas lógicas se realiza mediante inyección de dependencias.</li>
<li><strong>Pattern: Repository</strong>
La mediación entre el dominio de negocio y la persistencia se la delegamos a un repositorio. </li>
</ul>
<h4>Servicios Expuestos</h4>
<ul>
  <li><strong>BankABC-Agreement</strong> Servicio encargado del crud de los convenios.</li>
  <li><strong>BankABC-Transform</strong> Servicio encargado de la transformación de los mensajes.</li>
  <li><strong>Bank-Orchestration</strong> Servicio encargado de orquestar la peticiones a los otros servicios y de realizar el enrutamiento a los servicios de proveedores.</li>
