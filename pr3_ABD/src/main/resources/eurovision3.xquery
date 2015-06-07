xquery version "3.0";


declare variable $anyo as xs:integer := 2015;
for $ed in doc("eurovision.xml")/eurovision/edicion

where $ed/@numero=$anyo

return 
<body>
<h1> {data($ed/ubicacion)} ( {data($ed/ciudad)} )</h1>
<ol>
{for $b in $ed/pais
let $pais := $b/@nombre
let $autor := doc("eurovision.xml")//artista[@id=$b/participante/@id]
order by $b/orden ascending
return 
<li>
    <p> {data($pais)}  - {data($autor/nombre)}  - <i> {data($b/cancion)}  </i></p>
    <p> {data($autor/descripcion)}  </p>
    <img src="  {data($autor/imagen)}  "/>
    <p><b>Recibió votos de: </b>  {string-join(for $c in $b/votos return($c/@id_pais), ', ')} </p>
</li>
} 
</ol>
</body>