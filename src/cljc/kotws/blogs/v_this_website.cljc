(ns kotws.blogs.v-this-website
  (:require [kotws.lang :as klang]
            [kotws.links :as klinks]
            [kotws.components.v-labelled-image :as kvlabelled-image]))

(def dic
  {:teaching {:fr "Ce site", :en "This website"},
   :introduction
     {:fr
        [:div [:h2 "Les bibliothèques"]
         [:p
          "Peu de bibliothèques sont utilisées pour réaliser ce site. C'est un choix délibéré qui implique:"]
         [:ul [:li "Une surface d'attaque diminuée."]
          [:li "Une liberté complète."] [:li "Une maîtrise complète."]]
         [:h2 "L'emprunte de ce site"]
         [:p
          "Le poids du site web est d'1,5 Méga octets pour la page d'accueil, html, css et javscript y compris. Cette taille est très modérée, elle rends le chargement de la page très rapide."]
         [:h2 "Mode sombre"]
         [:p
          "Le site s'affiche en mode sombre si vos paramètres systèmes le spécifie."]
         [:h2 "Impression"]
         [:p
          "L'impression d'une page du site supprime les informations de navigation non nécessaire, adapte la mise en page."]
         [:h2 "Le multi-langue"]
         [:p
          "Deux versions sont disponibles, Anglais et Français. Les préférences de votre navigateur sont utilisées pour choisir la langue par défaut du site. L'utilisateur peut contourner ce choix qui sera stocké dans votre `local storage`. La traduction est réalisée sur le frontend, pas seulement le texte mais certaines image ou document lié."]
         [:h2 "Robustesse"]
         [:p
          "La définition de tous les liens est centralisée. Ainsi, ils sont testables, et les balises `<a/>` contienne un attribut `link-name` rappelant le nom du lien utilisé."]
         [:h2 "Responsive"]
         [:p
          "Quel que soit la taille de votre écran, de votre typographie, le site s'adapte au contenu."]
         [:h2 "Code source"]
         [:p "Tout le code de ce site est visible sur github:"]
         [kvlabelled-image/raw-image (klinks/image-link :git-hub)
          (klinks/external-link :sasu-caumond) nil :small]],
      :en
        [:div [:h2 "Libraries"]
         [:p
          "Few libraries are used to create this site. This is a deliberate choice that implies:"]
         [:ul [:li "A reduced attack surface."] [:li "A complete freedom."]
          [:li "A complete control."]] [:h2 "The imprint of this site"]
         [:p
          "The weight of the website is 1.5 Megabytes for the home page, html, css and javascript included. This size is very moderate, it makes the loading of the page very fast."]
         [:h2 "Dark mode"]
         [:p
          "The site is displayed in dark mode if your system settings specify it."]
         [:h2 "Printing"]
         [:p
          "Printing a page of the site removes unnecessary navigation information, adapts the layout."]
         [:h2 "Multi-language"]
         [:p
          "Two versions are available, English and French. Your browser preferences are used to choose the default language of the site. The user can override this choice which will be stored in your `local storage`. The translation is done on the frontend, not only the text but some images or linked documents."]
         [:h2 "Robustness"]
         [:p
          "The definition of all links is centralized. So, they are testable, and the `<a/>` tags contain a `link-name` attribute recalling the name of the link used."]
         [:h2 "Responsive"]
         [:p
          "Whatever the size of your screen, your typography, the site adapts to the content."]
         [:h2 "Source code"]
         [:p "All the code of this site is visible on github:"]
         [kvlabelled-image/raw-image (klinks/image-link :git-hub)
          (klinks/external-link :sasu-caumond) nil :small]]}})

(defn v-this-website
  [l]
  (let [current-tr (partial klang/tr dic l)]
    [:<> [:h1.text (current-tr :teaching)]
     [:div.text (current-tr :introduction)]]))
