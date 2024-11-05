(ns kotws.pages.v-home
  (:require [kotws.lang :as klang]
            [kotws.links :as klinks]
            [kotws.components.v-images :as kvimages]
            [kotws.components.v-lang :as kvlang]
            [kotws.components.v-space :as kvspace]
            [kotws.components.v-labelled-image :as vclabelled-image]))

(def dic
  {:home-msg {:en "Resume", :fr "Curriculum vitae"},
   :home-intro
     {:en
        "I have developed three main skills: First and foremost, I am a computer scientist, but I have invested myself in an exceptional application area: the industry and its supply chain. As supply chain softwares are very focused on decision-making, operational research is a useful complement and a major competitive advantage.",
      :fr
        "J'ai développé trois compétences principales: Avant tout, je suis informaticien, mais je me suis investi dans un domaine d'application exceptionnel: la chaîne logistique et l'industrie. Comme les logiciels de chaîne logistique sont très centré sur la prise de décision, la recherche opérationnelle est un complément utile et un avantage compétitif majeur."},
   :next
     {:en
        "View my resume below, or choose one of the more detailed forms from one of the four images below.",
      :fr
        "La prochaine étape est naturelle pour moi: Assembler ces compétences dans une offre pour les PMIs, où avoir une petite équipe est la culture et ce qui est compatible avec les montants des investissements."},
   :founder {:en "Hephaistox's founder", :fr "Fondateur d'Hephaistox"},
   :it {:en "Computing", :fr "Informatique"},
   :or {:en "Mathematics", :fr "Mathématiques"},
   :sc {:en "Supply chain", :fr "Chaîne logistique"},
   :resume-download
     {:en
        "You can read my resume through these four point of views or the more classical document below.",
      :fr
        "Visualisez mon cv ci-dessous, ou choisissez une des formes plus détaillées sur une des quatre images ci-dessous."}})

(def items
  {:docs {:caumond-resume {:fr {:img-link :caumond-cv, :href-link :caumond-cv},
                           :en {:img-link :caumond-resume,
                                :href-link :caumond-resume}}},
   :skills {:it {}, :sc {}, :or {:img-link :math}},
   :founding {:img-link :hephaistox}})

(def tr (partial klang/tr dic))

(defn defaulting
  [items _tr]
  (-> items
      (update :skills
              #(kvimages/defaulting % klinks/route-link klinks/image-link))
      (update :docs #(kvlang/defaulting % klinks/image-link klinks/doc-link))))

(def defaulting* (memoize defaulting))

(defn v-home
  [l]
  (let [{:keys [docs skills founding]} (defaulting* items tr)
        current-tr (partial tr l)
        w :small]
    [:<> [:h1.text (current-tr :home-msg)]
     [:p.text (current-tr :resume-download)] [kvspace/vertical-spacing]
     [kvlang/vclabelled-image l (:caumond-resume docs)]
     [:p.text (current-tr :home-intro)] [kvspace/vertical-spacing]
     [kvimages/image-cells skills current-tr :small] [kvspace/vertical-spacing]
     [:div.text (current-tr :next)]
     [:div.w3-center
      [vclabelled-image/labelled-image (klinks/image-link (:img-link founding))
       (klinks/route-link :founder) (current-tr :founder) w]]
     [kvspace/vertical-spacing]]))
