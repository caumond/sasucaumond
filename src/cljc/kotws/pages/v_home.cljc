(ns kotws.pages.v-home
  (:require [kotws.lang :as klang]
            [kotws.links :as klinks]
            [kotws.components.v-lang :as kvlang]
            [kotws.components.v-space :as kvspace]
            [kotws.components.v-labelled-image :as vclabelled-image]))

(def dic
  {:home-msg {:en "Resume", :fr "Curriculum vitae"},
   :home-intro
     {:en
        [:div [:p "My background is atypical and multiple:"]
         [:table
          [:tbody [:tr [:th {:style {:width "30%"}}]]
           [:tr
            [:td
             [vclabelled-image/labelled-image (klinks/image-link :it)
              (klinks/route-link :it) nil :small]]
            [:td
             [:a (klinks/link-meta (klinks/route-link :it))
              [:p
               "I have been in IT for over 30 years, I have developed management and optimization softwares, CLIs, web, backend frontend technologies, with diverse and varied databases, software with a large load and a small number of users, as well as software with a large load and a large number of users, from  development and architecture."]]]]
           [:tr
            [:td
             [vclabelled-image/labelled-image (klinks/image-link :sc)
              (klinks/route-link :sc) nil :small]]
            [:td
             [:a (klinks/link-meta (klinks/route-link :sc))
              [:p
               "In supply chain, I worked on order to cash processes, demand management, production planning, operational, tactical and strategic. I passed the APICS certification for the supply chain and led business transformation projects that go with it. Finally, I worked with the main software publishers: Oracle, INFOR, OMP, Blue Yonder."]]]]
           [:tr
            [:td
             [vclabelled-image/labelled-image (klinks/image-link :math)
              (klinks/route-link :or) nil :small]]
            [:td
             [:a (klinks/link-meta (klinks/route-link :or))
              [:p
               "I have created about ten optimization tools in various fields, some being academic advances, some in prototype mode and others that have been in production for more than 10 years."]]]]
           [:tr
            [:td
             [vclabelled-image/labelled-image (klinks/image-link :teaching)
              (klinks/route-link :teaching) nil :small]]
            [:td
             [:a (klinks/link-meta (klinks/route-link :teaching))
              [:p
               "I have done more than 500 hours of training, with computer science, mathematics and supply chain subjects, from bachelor to master degree."]]]]]]],
      :fr
        [:div [:p "Mon parcours est atypique et multiple:"]
         [:table
          [:tbody [:tr [:th {:style {:width "30%"}}]]
           [:tr
            [:td
             [vclabelled-image/labelled-image (klinks/image-link :it)
              (klinks/route-link :it) nil :small]]
            [:td
             [:a (klinks/link-meta (klinks/route-link :it))
              [:p
               "Je suis informaticien depuis plus de 30 ans, j'ai développé des logiciels de gestion et d'optimisation, dans des technologies `terminal`, web, backend frontend, avec des bases de données diverses et variées, des logiciels avec une grosse charge et un petit nombre d'utilisateurs, comme des logiciels avec grosse charge et gros nombre d'utilisateurs, du développement et de l'architecture."]]]]
           [:tr
            [:td
             [vclabelled-image/labelled-image (klinks/image-link :sc)
              (klinks/route-link :sc) nil :small]]
            [:td
             [:a (klinks/link-meta (klinks/route-link :sc))
              [:p
               "En chaîne logistique, j'ai travaillé sur des processus de prises de commande, la gestion de la demande, de la planification de production, en opérationnel, tactique et stratégique. J'ai passé la certification APICS pour la chaîne logistique et mené des projets de transformation métier qui vont avec. Pour finir, j'ai travaillé avec les principaux éditeurs de progiciels: Oracle, INFOR, OMP, Blue Yonder."]]]]
           [:tr
            [:td
             [vclabelled-image/labelled-image (klinks/image-link :math)
              (klinks/route-link :or) nil :small]]
            [:td
             [:a (klinks/link-meta (klinks/route-link :or))
              [:p
               "J'ai réalisé une petite dizaine d'outils d'optimisation dans des domaines variés, certains étant des avancées académiques, certains faisant en mode prototypes et d'autres qui sont en production depuis plus de 10 ans."]]]]
           [:tr
            [:td
             [vclabelled-image/labelled-image (klinks/image-link :teaching)
              (klinks/route-link :teaching) nil :small]]
            [:td
             [:a (klinks/link-meta (klinks/route-link :teaching))
              [:p
               "J'ai plus de 500 heures de formations à mon actif, avec des sujets informatiques, mathématiques et de chaîne logistique, de bac +1 à bac +5."]]]]]]]},
   :next
     {:en
        "The next step is natural for me: An offer that integrates the capture of the need up to the realization of the IT tool, as well as the training. Especially adapted for complex subjects where too many interlocutors make the project impossible, or for SMEs where having an interlocutor managing all the aspects is compatible with the cost and the corporate culture.",
      :fr
        "La prochaine étape est naturelle pour moi: Une offre qui intègre de la capture du besoin jusqu'à la réalisation de l'outil informatique, ainsi que la formation. Spécialement adapté pour les sujets complexes où trop d'interlocuteurs rends le projet impossible, ou pour les PMIs où avoir un interlocuteur gérant tous les aspects est compatible avec le coût et la culture d'entreprise."},
   :founder {:en "Hephaistox's founder", :fr "Fondateur d'Hephaistox"},
   :it {:en "Computing", :fr "Informatique"},
   :or {:en "Mathematics", :fr "Mathématiques"},
   :sc {:en "Supply chain", :fr "Chaîne logistique"}})

(def items
  {:docs {:caumond-resume {:fr {:img-link :caumond-cv, :href-link :caumond-cv},
                           :en {:img-link :caumond-resume,
                                :href-link :caumond-resume}}},
   :founding {:img-link :hephaistox}})

(def tr (partial klang/tr dic))

(defn defaulting
  [items _tr]
  (-> items
      (update :docs #(kvlang/defaulting % klinks/image-link klinks/doc-link))))

(def defaulting* (memoize defaulting))

(defn v-home
  [l]
  (let [{:keys [docs founding]} (defaulting* items tr)
        current-tr (partial tr l)
        w :small]
    [:<> [:h1.text (current-tr :home-msg)] [kvspace/vertical-spacing]
     [kvlang/vclabelled-image l (:caumond-resume docs)]
     [:div.text (current-tr :home-intro)] [kvspace/vertical-spacing]
     [:div.text (current-tr :next)]
     [:div.w3-center
      [vclabelled-image/labelled-image (klinks/image-link (:img-link founding))
       (klinks/route-link :founder) nil w]] [kvspace/vertical-spacing]]))
