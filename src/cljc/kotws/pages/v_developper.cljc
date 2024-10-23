(ns kotws.pages.v-developper
  (:require [kotws.language :as klang]
            [kotws.components.v-headered-list :as kvheadered-list]))

(def dic
  {:developper {:fr "Développeur", :en "Developer"},
   :intro
     {:en
        "I started development when I was 10 years old, when much less resources were available. This is a passion that has accompanied me all my life long, as a side project, a tool, and now as a support of the offer of my enterprise.",
      :fr
        "J'ai démarré le développement vers 10 ans, à une époque où beaucoup moins de ressources étaient disponibles. C'est une passion qui m'a accompagné tout le long de ma vie, comme un loisir, un outil, et maintenant comme support de l'offre de l'entreprise que je crée."},
   :demo-making {:fr "Démo et jeux", :en "Demo making and games"},
   :demo-making-desc
     {:en
        "I discovered development with game creation. They could be in text mode at that time (redefining fonts to define sprites), or in graphical mode. But I spent a lot of time to develop demos: vectorballs, rasters, overscans, wireframe 3D. I had to rediscover how to draw lines...",
      :fr
        "J'ai découvert le développement en créant des jeux, en mode texte (en redéfinissant les caractères) ou en mode graphique. Mais j'ai passé beaucoup de temps à faire des démos: des vectors balls, des rasters, des overscans, de la 3D en wireframe, en redécouvrant les algorithmes de traçage de lignes."},
   :jewelry-desc
     {:fr
        "A une époque où les logiciels de gestion professionnels étaient rares, j'ai eu l'occasion de construire le logiciel de gestion de stock de la bijouterie familiale en gfa basic. ",
      :en
        "At a time when professionnal software were quite scarce, I had the occasion to build one in GFA Basic, in order to manage the stock of the family jewelry."},
   :jewelry {:en "Jewelry stock management tool",
             :fr "Outil de gestion de stock pour bijouterie"},
   :gfa {:en "GFA basic, Z80 and 68000 assembly",
         :fr "Assembleur Z80 et 68000"},
   :gfa-desc
     {:fr
        "J'ai majoritairement utilisé ces deux languages pour les réalisations ci-dessus. J'ai aussi eu l'occasion de faire du Z80 et du language machine.",
      :en
        "I used mainly that two languages for the above achievements. I also had the opportunity to use Z80 and code machine."}})

(def cv-items
  (letfn [(c [l]
            (-> {:jewelry {:img-url "images/developper/demo_making.png"},
                 :gfa {:img-url "images/developper/demo_making.png"},
                 :demo-making-desc {:img-url
                                      "images/developper/demo_making.png"}}
                (klang/default-and-translate [:label :desc]
                                             (partial klang/tr dic l))))]
    (->> klang/possible-langs
         (mapv (fn [l] [l (c l)]))
         (into {}))))

(defn v-founder
  [l]
  (let [tr (partial klang/tr dic l)]
    [:<> [:h1 (tr :developper)] [:div.text (tr :intro)] [:hr]
     (-> (get cv-items l)
         kvheadered-list/detailed-list) [:hr]]))
