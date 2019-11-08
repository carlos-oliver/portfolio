describe 'Meu primeiro cenário' do
  it 'visitar a página' do 
    visit 'http://training-wheels-protocol.herokuapp.com/'
    expect(page.title).to eql 'Training Wheels Protocol'
  end 
end