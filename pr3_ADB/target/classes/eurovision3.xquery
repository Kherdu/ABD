xquery version "3.0";

declare variable $anyo as xs:integer external;

let $a := doc("Eurovision.xml")//edicion[anyo/text()=$anyo]



return 
<body>


<h1> {data($a/ubicacion)} ( {data($a/ciudad)} )</h1>
<ol>
Para cada actuación debe mostrarse lo siguiente:


{for $b in $a/pais
let $pais := $b/@nombre
let $idAut := $b//participante/@id
let $autor := doc("Eurovision.xml")//artista[idc/text()=$idAut]
order by $b/orden ascending
return <li>


<p> {data($pais)}  - {data($autor/nombre)}  - <i> {data($b/cancion)}  </i></p>

<p> {data($autor/descripcion)}  </p>
<img src="  {data($autor/imagen)}  "/>

<p><b>Recibidos votos de: </b>  {string-join(for $c in $b/votos return($c/@id_pais), ', ')} </p>
    
</li>
} 
</ol>

</body>