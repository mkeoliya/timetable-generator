ECTION24">3.3 Synchronisation source-pdf avec synctex</a></li>
	</ul>
</ul>
<ul>
<li><a href="#SECTION3">4. Autres caractéristiques de <b>Texmaker</b></a></li>
	<ul>
	<li><a href="#SECTION301">4.1 Replier/déplier des blocs d'un document</a></li>
	<li><a href="#SECTION31">4.2 Documents scindés en plusieurs fichiers</a></li>
	<li><a href="#SECTION32">4.3 Bibliographie</a></li>
	<li><a href="#SECTION33">4.4 Balises et commandes personnelles</a></li>
	<li><a href="#SECTION34">4.5 Support Pstricks/Metapost/Tikz/Asymptote</a></li>
	<li><a href="#SECTION35">4.6 Changer la langue</a></li>
	<li><a href="#SECTION36">4.7 La commande "Restaurer la session précédente"</a></li>
	<li><a href="#SECTION37">4.8 "Forward/Inverse search" avec Texmaker</a></li>
	<li><a href="#SECTION38">4.9 Synopsis de la commande texmaker</a></li>
	<li><a href="#SECTION39">4.10 Raccourcis clavier</a></li>
	<li><a href="#SECTION40">4.11 Le panneau "Source Viewer"</a></li>
<!--	<li><a href="#SECTION41">4.12 Imprimer un document pdf à partir de l'afficheur pdf intégré sous windows</a></li>-->
	<li><a href="#SECTION42">4.12 L'option "Utiliser un sous-répertoire 'build'..." pour la commande (pdf)latex</a></li>
	<li><a href="#SECTION43">4.13 Remplacer du texte avec une expression régulière</a></li>
	<li><a href="#SECTION44">4.14 Utilisation de texmaker comme éditeur Asymptote</a></li>
	<li><a href="#SECTION45">4.15 Étendre les fonctionnalités de l'éditeur avec des scripts</a></li>
	</ul>
</ul>
</div>
<br clear="all">
</fieldset>
</div>

<div class="post">
<fieldset>
<legend class="title"><a name="SECTION0">1. Configurer Texmaker</a></legend>
<div class="entry">
Avant d'utiliser Texmaker, il faut d'abord configurer l'éditeur et les commandes associées à LaTeX via l'option "Configurer Texmaker" du menu "Options" ("Préférences" sous macosx).
<h2><a name="SECTION01">1.1 Configurer l'éditeur</a></h2>
<p>
Avant de compiler son premier document, il faut d'abors régler l'encodage utilisé par l'éditeur ("Configurer Texmaker" -> "Editeur" -> "Encodage"). Il faut ensuite utiliser l'encodage correspondant dans le préambule des documents LaTeX (Exemple : \usepackage[latin]{inputenc}, si l'on utilise l'encodage "ISO-8859-1" pour l'éditeur).<br>
Note : lors de l'ouverture d'un fichier, l'utilisateur est prévenu si le document ne peut pas être décodé correctement avec l'encodage par défaut. Le programme laisse alors la possibilité de charger le fichier avec un autre encodage (sans que cela ne modifie l'encodage par défaut). 
</p>
<h2><a name="SECTION02">1.2 Configurer les commandes associées à LaTeX</a></h2>
<p>Pour pouvoir compiler les documents avec Texmaker, les chemins vers les commandes associées à LaTeX doivent être définis correctement.<br>
Les commandes par défaut devraient fonctionner avec les distributions LaTeX standards, mais des changements peuvent quand même être nécessaires ("Configurer Texmaker" -> "Commandes"). <b>Pour modifier une commande, il suffit d'utiliser le bouton en fin de ligne et de sélectionner le programme correspondant avec le sélecteur de fichiers</b> : Texmaker adaptera automatiquement la syntaxe (les modifications manuelles sont déconseillées).<br>
Le caractére <strong>%</strong> représente le nom du fichier courant (sans l'extension - représente la document maitre en mode "maître") et le caractére <strong>@</strong> sera automatiquement remplacé par le numéro de la ligne courante dans l'éditeur.<br>
Paramètre supplémentaire : <strong>#</strong> sera remplacé par le nom du fichier courant sans extension (y compris dans le mode "maître") et <strong>!</strong> sera remplacé par le répertoire courant.
</p>
<p><b>Remaque :</b> si les caractères %, !, # et @ sont nécessaires pour une commande, il suffit d'utiliser à la place %%, !!, ## et @@. Ces expressions seront remplacés par %, !, # et @ avant de lancer la commande.
</p>
<p><IMG src="doc14.png" border="1"></p>
<h2><a name="SECTION03">1.3 Configurer la vérification orthographique</a></h2>
<p>
Le système interne de vérification orthographique utilise les mêmes dictionnaires qu'Hunspell/OpenOffice.org (version 2.x).<br>
Pour configurer le fonctionnement du correcteur orthographique dans Texmaker : "Configurer Texmaker" -> "Editeur" -> "Dictionnaire" et utiliser le bouton en fin de ligne pour sélectionner le dictionnaire avec le sélecteur de fichiers.<br>
<b>Attention : la correction orthographique commence désormais à partir de la position du curseur et non plus à partir du début du document.</b><br>
Lors de la frappe, s'il y a une erreur, le mot est souligné par un liséré rouge. Un clic-droit sur le mot ouvre un menu contextuel dans lequel il y a des propositions de mots de remplacement. Cliquer sur le mot désiré pour effectuer le remplacement.
</p>
</div>
<br clear="all">
</fieldset>
</div>

<div class="post">
<fieldset>
<legend class="title"><a name="SECTION1">2. Rédaction d'un document avec l'éditeur</a></legend>
<div class="entry">
<h2><a name="SECTION11">2.1 Commandes usuelles</a></h2>
<p>Texmaker comporte les commandes habituelles d'un éditeur classique : Copier, Coller...<br>
Elles sont accessibles via le menu "Edition" et la première barre d'outils.<br>
La sélection par bloc rectangulaire est disponible en appuyant sur la touche Alt pendant l'utilisation de la souris.</p>
<p><IMG src="doc1.png" border="1"></p>
<h2><a name="SECTION12">2.2 Préambule du document</a></h2>
<p>Il y a plusieurs façons de rédiger le préambule de son document LaTeX.<br>
La première consiste à utiliser la commande "Démarrage rapide" du menu "Assistants" :</p>
<p><IMG src="doc2.png" border="1"></p>
<p>on peut y fixer les principales caractéristiques de son document (classe, format...). Les boutons "+" permettent de rajouter ses propres options. Tous ces réglages sont enregistrés : l'utilisateur les retrouvera à la prochaine utilisation de l'assistant.<br>
On peut aussi utiliser un modèle de préambule que l'on a préalablement enregistré. Il suffit alors d'utiliser "Enregistrer sous" ou un "copier/coller" pour l'utiliser comme base de son nouveau document.</p>
<h2><a name="SECTION13">2.3 Structuration du document</a></h2>
<p>L'un des points forts de LaTeX est la structuration des documents. Pour définir une nouvelle "section" avec <b>Texmaker</b>, il suffit d'utiliser cette liste de la barre d'outils :</p>
<p><IMG src="doc3.png" border="1"></p>
<p>On n'a plus qu'à indiquer le titre voulu et si l'on désire que cette section soit numérotée (elle fera alors partie de la table des matières) :</p>
<p><IMG src="doc4.png" border="1"></p>
<h2><a name="SECTION14">2.4 Navigation à l'intérieur d'un document</a></h2>
<p><b>Texmaker</b> facilite la navigation dans un long document LaTeX grâce à la vue structure située à gauche de l'interface :</p>
<p><IMG src="doc5.png" border="1"></p>
<p>Un simple clic sur un item permet d'atteindre la ligne correspondante dans l'éditeur. Cette vue structure est actualisée automatiquement lors de la frappe. L'utilisateur peut aussi utiliser la commande "Rafraîchir Structure" du menu "Edition" à tout moment.</p>
<p>Pour chaque fichier, l'utilisateur peut définir trois "signets" pour accelérer la navigation dans un document. Pour ajouter ou supprimer un "signet", il suffit de cliquer sur un numéro de ligne. Quand vous avez déja défini trois signets, il faut en supprimer un pour pouvoir en ajouter un nouveau. Pour atteindre la ligne correspondante à un signet, il suffit de cliquer sur les boutons "1,2,3" dans la barre d'état de Texmaker.</p>
<p><IMG src="doc20.png" border="1"></p>
<h2><a name="SECTION15">2.5 Mise en forme du texte avec <b>Texmaker</b></a></h2>
<p>Le formatage du texte peut se faire rapidement avec ceci :</p>
<p><IMG src="doc6.png" border="1"></p>
<p><IMG src="doc6bis.png" border="1"></p>
<p>Une des caractéristiques de <b>Texmaker</b> est la possibilité de sélectionner le texte à formater avant de cliquer sur ces boutons. Les balises LaTeX adéquates entourent alors automatiquement le texte sélectionné.</p>
<h2><a name="SECTION16">2.6 Espacement - Sauts de ligne</a></h2>
<p>Les commandes d'espacement usuelles sont disponibles dans le menu "LaTeX - Espacement".
Le bouton "Retour à la ligne" (raccourci-clavier : Ctrl+Return) permet aussi d'insérer rapidement le code LaTeX pour un retour à la ligne.</p>
<h2><a name="SECTION17">2.7 Insertion d'une liste</a></h2>
<p>Le menu "LaTeX - Listes" permet d'insérer rapidement le squelette des environnements listes traditionnels de LaTeX. Le raccourci-clavier pour insérer rapidement un item est : Ctrl+Shift+I.</p>
<h2><a name="SECTION18">2.8 Insertion d'un tableau</a></h2>
<p><b>Texmaker</b> propose un assistant permettant d'insérer le code adéquat pour la plupart des tableaux standards. Il suffit d'utiliser la commande "Assistant tableau" du menu "Assistants". On se retrouve alors devant la boîte de dialogue ci-dessous.</p>
<p><IMG src="doc7.png" border="1"></p>
<p>On peut y définir les caractéristiques du tableau (nombre de lignes et de colonnes, alignement, séparateur...). Il est même possible d'entrer directement le texte de chaque cellule (on peut aussi les laisser vides et compléter la tableau alors dans l'éditeur). Le code LaTeX adéquat est alors automatiquement inséré.</p>
<h2><a name="SECTION19">2.9 Tabulation</a></h2>
<p>L'"Assistant Tabulation" du menu "Assistants" permet d'insérer automatiquement le code LaTeX d'une tabulation simple grâce à la boîte de dialogue ci-dessous.</p>
<p><IMG src="doc8.png" border="1"></p>
<h2><a name="SECTION110">2.10 Insertion d'images</a></h2>
<p>L'insertion d'une image se fait grâce à la commande "\includegraphics{}" du menu "LaTeX". En cliquant sur l'icône "fichier" de la boîte de dialogue ci-dessous, on peut alors sélectionner l'image à inclure. Remarque : en cliquant sur le bouton "+", un environnement "figure" sera automatiquement ajouté.</p>
<p><IMG src="doc9.png" border="1"></p>
<h2><a name="SECTION111">2.11 Références croisées et notes</a></h2>
<p>La deuxième liste de la barre d'outils est à la disposition des utilisateurs pour insérer rapidement les commandes LaTeX usuelles pour les références croisées et les notes de bas de page. Les labels utilisés dans le document apparaissent dans la vue structure : un clic suffit à les atteindre dans l'éditeur.</p>
<p><IMG src="doc10.png" border="1"></p>
<p>Remarque :  Pour la commande \ref , <b>Texmaker</b> propose de sélectionner un label parmi la liste de labels détectés dans le document (utiliser la commande "Rafraîchir Structure" du menu "Edition" pour actualiser éventuellement la liste).</p>
<h2><a name="SECTION112">2.12 Insertion de formules mathématiques</a></h2>
<p>Le passage en mode mathématique (en ligne) se fait avec le bouton "$$" de la barre d'outils "Math" ou grâce au raccourci-clavier Ctrl+Alt+M. Pour le mode hors-ligne, on peut utiliser la commande "$$...$$" du menu "Math" ou le raccourci-clavier Alt+Shift+M.<br>
La barre d'outils mathématiques permet aussi d'insérer d'un seul clic les formes mathématiques les plus courantes (fraction, racine...).</p>
<p><IMG src="doc11.png" border="1"></p>
<p>Les panneaux de symboles mathématiques situés à gauche permettent d'insérer d'un clic le code LaTeX de près de 400 symboles, ainsi que les balises \left et \right (cliquer sur les boutons "symboles" de la vue structure pour cela).</p>
<p><IMG src="doc12.png" border="1"></p>
<p><b>Option supplémentaire :</b> Un panneau <b>"symboles favoris"</b> (*) permet à l'utilisateur de créer son propre panneau de symboles. 
<ul>
<li>Pour ajouter un symbole dans le panneau "symboles favoris", il suffit de faire un clic-droit sur un symbole dans les autres panneaux de symboles et de sélectionner l'option "Ajouter aux favoris" dans le menu qui s'affiche.</li>
<li>Pour supprimer un symbole du panneau "symboles favoris", il suffit de faire un clic-droit dessus et de sélectionner l'option "Retirer des favoris" dans le menu qui s'affiche.</li>
</ul>
</p>
<p>Le menu "Math" permet aussi de définir le style du texte en mode mathématique (accents, styles de caractères,espacement)<br>
Pour les matrices, un assistant basé sur le même principe que celui pour les tableaux est disponible dans le menu "Assistants". Il permet en plus de fixer l'environnement (array, matrix, pmatrix...). Les cellules peuvent être complétées directement dans l'assistant.</p>
<p><IMG src="doc13.png" border="1"></p>
<h2><a name="SECTION113">2.13 Utilisation des marques "