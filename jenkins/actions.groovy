def handle_success(def cfg) {

    echo "In handle success of actions groovy"

} 

def test_call(def cfg) {

    echo "In test_call of actions groovy"

}

def ansible_deploy(def cfg) {

   stage('ansible_deploy') {
      echo 'MY TRY AT ansible_deploy'
   }

}


return this;