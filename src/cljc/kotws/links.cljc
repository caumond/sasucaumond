(ns kotws.links
  "Link library that can be automatically checked by the doctor.

  Use `get-url`"
  (:require [kotws.pages :as kpages]
            [kotws.sub-map :as ksubmap]))

(def site-url "" #_"https://caumond.fr/")

(def ^:private external-links-data
  {:apics "https://www.afrscm.fr/762_p_44059/cpim.html",
   :babashka "https://github.com/babashka/babashka#installation",
   :clever-cloud "https://www.clever-cloud.com/en/",
   :clojure "https://clojure.org",
   :clojurescript "https://clojurescript.org/",
   :cor-time-lag
     "https://www.sciencedirect.com/science/article/pii/S0305054806002930",
   :demo-making "https://en.wikipedia.org/wiki/Demoscene",
   :distribution-network
     "https://fr.wikipedia.org/wiki/Algorithme_de_Busacker_et_Gowen",
   :doom-emacs "https://github.com/doomemacs/doomemacs",
   :downstream-ope
     "https://www.usinenouvelle.com/article/michelin-veut-reduire-ses-frais-generaux-de-500-millions-d-euros-d-ici-2020.N396442",
   :drp "https://en.wikipedia.org/wiki/Distribution_resource_planning",
   :ejor-transport
     "https://www.sciencedirect.com/science/article/abs/pii/S0377221708004608",
   :flaticon "https://www.flaticon.com/icons",
   :fontawesome "https://fontawesome.com/v4/",
   :git-hub "https://github.com/caumond",
   :hephaistox "https://hephaistox.com",
   :hephaistox-gh "https://github.com/hephaistox",
   :isima
     "https://www.isima.fr/formations/formation-ingenieur/f3-systemes-dinformation-et-aide-a-la-decision/",
   :jewelry-ecommerce
     "https://web.archive.org/web/20060614232036/http:/www.bijouteriecaumond.fr/",
   :linkedin "https://www.linkedin.com/in/anthony-caumond-a365b15/",
   :make-or-buy-optimization
     "https://www.investopedia.com/terms/m/make-or-buy-decision.asp",
   :phd "https://tel.archives-ouvertes.fr/tel-00713587/document",
   :plm "https://fr.wikipedia.org/wiki/Gestion_du_cycle_de_vie_(produit)",
   :re-frame "https://github.com/day8/re-frame",
   :reitit "https://github.com/metosin/reitit",
   :ring "https://github.com/ring-clojure/ring",
   :sasu-caumond "https://github.com/caumond/sasucaumond",
   :sasu-societe "https://www.societe.com/societe/caumond-905156402.html",
   :slack "https://clojurians.slack.com/team/U018QDQGZ9Q",
   :seb "https://videos.confluent.io/watch/Uny8xop6vWZut5Hb5CaNpA?",
   :software-purchasing
     "https://www.strategieslogistique.com/Michelin-ameliore-son-S-OP-avec",
   :storrito "http://www.storrito.com",
   :upstream-ope
     "https://www.usinenouvelle.com/article/michelin-veut-reduire-ses-frais-generaux-de-500-millions-d-euros-d-ici-2020.N396442",
   :w3-css "https://www.w3schools.com/w3css/default.asp",
   :w3-template
     "https://www.w3schools.com/w3css/tryw3css_templates_portfolio.htm",
   :web-caumond-archive
     "https://web.archive.org/web/20060614232036/http:/www.bijouteriecaumond.fr/",
   :togaf "docs/togaf.pdf",
   :z80 "https://en.wikipedia.org/wiki/Zilog_Z80"})

(def ^:private image-links-data
  {:apics {:filename "cpim.png"},
   :archi {:filename "archi.png"},
   :anthony {:filename "anthonycaumond.jpg", :alt "Anthony's picture"},
   :babashka {:filename "babashka.png"},
   :bcoo {:filename "bcoo.png"},
   :caumond-resume {:filename "caumond_resume.jpg"},
   :caumond-cv {:filename "caumond_cv.jpg"},
   :clever-cloud {:filename "clever-cloud.svg"},
   :clojure {:filename "clojure.png"},
   :clojurescript {:filename "clojurescript.png"},
   :cor-time-lag {:filename "cor_time_lag.png"},
   :distribution-network {:filename "distribution_network.png"},
   :demo-making {:filename "demo_making.png"},
   :doom-emacs {:filename "doom.png"},
   :downstream-ope {:filename "framing.png"},
   :drp {:filename "drp.png"},
   :ejor-transport {:filename "ejor_transport.png"},
   :falsestart {:filename "false_start.png"},
   :forge-workshop {:filename "forging.png"},
   :git-hub {:filename "gh.jpeg"},
   :gonogo {:filename "gonogo.png"},
   :hephaistox {:filename "hephaistox_logo.png"},
   :isima {:filename "isima.png"},
   :it {:filename "it.png"},
   :jewelry {:filename "jewelry.png"},
   :kafka {:filename "kafka.png"},
   :make-or-buy-optimization {:filename "make_or_buy.png"},
   :market-knowledge {:filename "people_network.png"},
   :math {:filename "math.png"},
   :no-image {:filename "no_image.png"},
   :optimization {:filename "optimization.png"},
   :phd {:filename "graduation_cap.png"},
   :plm-start {:filename "fill_the_gap.png"},
   :plm {:filename "plm.png"},
   :pp {:filename "pp.png"},
   :psa {:filename "psa.png"},
   :re-frame {:filename "re-frame.png"},
   :sc {:filename "sc.png"},
   :storrito {:filename "storrito.png"},
   :software-purchasing {:filename "software_purchasing.png"},
   :tire {:filename "tires.png"},
   :tissue-tactical-planning {:filename "graduation_cap.png"},
   :upstream-ope {:filename "ope_upstream.jpg"},
   :web-caumond {:filename "web_caumond.png"},
   :z80 {:filename "Z80.png"}})

(def ^:private doc-links-data
  {:caumond-resume {:filename "caumond_resume.pdf"},
   :caumond-cv {:filename "caumond_cv.pdf"}})

(def external-links
  (-> (map (fn [[link-name external-link]] [link-name
                                            {:url external-link,
                                             :type :external-url}])
           external-links-data)
      (ksubmap/add-key :name)))

(defn external-link [kw] (get external-links kw))

(def image-links
  (-> image-links-data
      (ksubmap/add-key :name)
      (update-vals (fn [{:keys [filename]}]
                     {:type :image-link,
                      :url (str site-url "images/" filename),
                      :filename filename}))))

(defn image-link "The image `url` matching `kw`" [kw] (get image-links kw))

(def doc-links
  (-> doc-links-data
      (ksubmap/add-key :name)
      (update-vals (fn [{:keys [filename], :as doc-link}]
                     (assoc doc-link
                       :type :doc-link
                       :url (str "docs/" filename))))))

(defn doc-link [kw] (get doc-links kw))

(def route-links kpages/pages)

(defn route-link "The route `url` matching `kw`" [kw] (get route-links kw))

(def ^:deprecated all-urls
  (->> (concat (->> external-links
                    (mapv
                      (fn [[name url]]
                        [name {:type :external-url, :url url, :name name}])))
               (->> image-links-data
                    (mapv (fn [[name url]] [name
                                            {:type :image-link,
                                             :url (str site-url "images/" url),
                                             :name name}])))
               kpages/pages)
       (into {})))


(defn ^:deprecated get-url [kw] (get-in all-urls [kw :url]))
