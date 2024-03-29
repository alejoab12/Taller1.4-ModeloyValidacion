<h3>Taller de modelo y validación</h3>
<h4>Arquitectura Propuesta</h4>

Se realizo una aproximacion de un estilo de  arquitectura de micro-servicios y un estilo de arquitectura SOA, ambos estilos nos proporcionan patrones que pensamos que aportan beneficios a la solución,  reduciendo acoplamiento, centrandonos en la responsabilidad única por dominio de negocio y generando retorno de valor a la organización.
Se realizo una composicion por orquestación de servicios.
<h6>La arquitectura se soporta en diferentes patrones, los cuales son:</h6>
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
<li><strong>Pattern:Inventory Endpoint:</strong>
 Se realizo un inventario de servicios en swagger hub, permitiendo descrubir con facilidad los servicios y sus urls.
</li> 
<li><strong>Pattern:Decoupled Contract</strong>
  Se construyeron los contratos con la especificacion OPEN API 3.0 y se exponen en swagger hub.
</li>
</li> 
<li><strong>Pattern:Service Layers</strong>
  Se separan los servicios por capas de utilidad, tarea, procesos.
</li>
</ul>
<h4>Servicios Expuestos</h4>
<ul>
  <li><a href="https://github.com/alejoab12/Taller1.4-ModeloyValidacion/tree/master/BankABC-Agreement"><strong>BankABC-Agreement</strong> </a>
    Servicio encargado del crud de los convenios.
  </li>
  <li><a href="https://github.com/alejoab12/Taller1.4-ModeloyValidacion/tree/master/BankABC-Transform"><strong>BankABC-Transform</strong></a> Servicio encargado de la transformación de los mensajes.</li>
  <li><a href="https://github.com/alejoab12/Taller1.4-ModeloyValidacion/tree/master/Bank-Orchestration"><strong>Bank-Orchestration</strong></a> Servicio encargado de orquestar la peticiones a los otros servicios y de realizar el enrutamiento a los servicios de proveedores.</li>
  </ul>
  <h5><strong>API de consulta y pago:</strong>https://app.swaggerhub.com/apis-docs/MyV-javeriana/bancoabc-servicio-convenios/1.0.0</h5>
  
  <h6><strong>Grupo:</strong><ul><li>Farid Eliecer Ureche Lopez</li><li>Manuel Alejandro Alcala Bustos</li></ul>
